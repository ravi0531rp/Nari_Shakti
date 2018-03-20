package com.example.moksh;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moksh.loginandregister.HumanDevelopment;
import com.example.moksh.loginandregister.MainActivity;
import com.example.moksh.loginandregister.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class SellActivity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST=1;
    public Button mButtonChooseImage;
    public Button mButtonUpload;
    private EditText mEditTextFilename;
    private ImageView mIMageView;
    private ProgressBar mProgressBar;
    private Uri mImageUri;
    private StorageReference mstorageRef;
    private DatabaseReference mDatabaseRef;
    private StorageTask mUploadTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        mButtonChooseImage = (Button) findViewById(R.id.button_choose_image);
        mButtonUpload = (Button) findViewById(R.id.upload_button);
        mEditTextFilename = (EditText) findViewById(R.id.edit_text_file_name);
        mIMageView= (ImageView) findViewById(R.id.image_view);
        mProgressBar=(ProgressBar)findViewById(R.id.progress_bar);
        mstorageRef = FirebaseStorage.getInstance().getReference("uploads");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads ");
        mButtonChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });
        mButtonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mUploadTask!=null && mUploadTask.isInProgress()){
                    Toast.makeText(SellActivity.this, "Uploading is in progress", Toast.LENGTH_SHORT).show();

                }else{
                    uploadFile();
                }
            }
        });
    }
    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data!= null && data.getData()!=null){
            mImageUri = data.getData();
            Picasso.with(this).load(mImageUri).into(mIMageView);
        }
    }
    private  String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }
    private void uploadFile() {
        if(mImageUri!=null){
            StorageReference fileReferences = mstorageRef.child(System.currentTimeMillis()
                    +"."+getFileExtension(mImageUri));
            mUploadTask = fileReferences.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mProgressBar.setProgress(0);
                                }
                            },5000);
                            Toast.makeText(SellActivity.this, "Upload successful", Toast.LENGTH_LONG).show();
                            Upload upload = new Upload(mEditTextFilename.getText().toString().trim(),
                                    taskSnapshot.getDownloadUrl().toString());
                            String uploadId = mDatabaseRef.push().getKey();
                            mDatabaseRef.child(uploadId).setValue(upload);
                            startActivity(new Intent(SellActivity.this, HumanDevelopment.class));
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SellActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                            mProgressBar.setProgress((int)progress);
                        }
                    });
        }
        else{
            Toast.makeText(this,"No files selected",Toast.LENGTH_SHORT).show();
        }
    }

}
