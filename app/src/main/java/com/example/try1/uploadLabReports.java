package com.example.try1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class uploadLabReports extends AppCompatActivity {
    EditText editNoteName;
    Button btn_notesup;

    StorageReference storageReference;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_lab_reports);

        editNoteName=(EditText)findViewById(R.id.notenameupload);
        btn_notesup=findViewById(R.id.uploadnotes_btn);

        storageReference= FirebaseStorage.getInstance().getReference();
        databaseReference= FirebaseDatabase.getInstance().getReference("LabReport");

        btn_notesup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectNotesFile();
            }
        });
    }

    private void selectNotesFile(){
        Intent intent=new Intent();
        String[] mimeTypes={"image/*","application/*","video/*"};
        //intent.setType("image/*||application/*");
        intent.setType(mimeTypes.length==1?mimeTypes[0]:"*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Report File"),1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            uploadNotes(data.getData());
        }
    }

    private void uploadNotes(Uri data) {

        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Uploading Reports......");
        progressDialog.show();

        StorageReference reference=storageReference.child("reports/"+System.currentTimeMillis()+".pdf");
        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> uri= taskSnapshot.getStorage().getDownloadUrl();
                        while(!uri.isComplete());
                        Uri url=uri.getResult();

                        labreporthelperclass labreporthelperclass=new labreporthelperclass(editNoteName.getText().toString(),url.toString());
                        databaseReference.child(databaseReference.push().getKey()).setValue(labreporthelperclass);
                        Toast.makeText(uploadLabReports.this,"Reports Uploaded",Toast.LENGTH_SHORT ).show();
                        progressDialog.dismiss();
                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double progress=(100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                progressDialog.setMessage("Uploaded : "+(int)progress+"%");


            }
        });
    }



    public void btn_action1(View view) {
        startActivity(new Intent(getApplicationContext(),viewlabupload.class));
    }
}