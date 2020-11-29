package com.example.try1;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

public class clinicalDataD extends fillCaseHistory {

    private static final int PICK_IMAGE_REQUEST = 1;

    private Button bBlood, bUrine, bECG, bEndo;
    private TextView tBlood, tUrine, tECG, tEndo;
    private Button bBlood1, bUrine1, bECG1, bEndo1;
    private Uri Bloodreport, urineReport, ecgReport, endoReport;
    private ProgressBar progressBarEndoD,progressBarECGD, progressBarBD, progressBarUD;
    private StorageReference storage;
    private DatabaseReference database;
    private StorageTask uploadBlood, uploadUrine, uploadEcg, uploadEndo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinical_data_d);

        clinicDUI();
        buttonsCD();


    }

    private void buttonsCD() {
        bBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();
            }
        });
        bUrine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();
            }
        });
        bECG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();
            }
        });
        bEndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();
            }
        });

        bBlood1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (uploadBlood != null && uploadBlood.isInProgress()){
                    Toast.makeText(clinicalDataD.this, "Upload in Progress", Toast.LENGTH_SHORT).show();

                }else {
                    uploadBloodReport();
                }
            }
        });
        bUrine1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (uploadUrine != null && uploadUrine.isInProgress()){
                    Toast.makeText(clinicalDataD.this, "Upload in Progress", Toast.LENGTH_SHORT).show();

                }else {
                    uploadUrineReport();
                }
            }
        });
        bECG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (uploadEcg != null && uploadEcg.isInProgress()){
                    Toast.makeText(clinicalDataD.this, "Upload in Progress", Toast.LENGTH_SHORT).show();

                }else {
                    uploadECGReport();
                }
            }
        });
        bEndo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (uploadEndo != null && uploadEndo.isInProgress()){
                    Toast.makeText(clinicalDataD.this, "Upload in Progress", Toast.LENGTH_SHORT).show();

                }else {
                    uploadEndoReport();
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

    //picking the image
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            Bloodreport = data.getData();
            urineReport = data.getData();
            endoReport = data.getData();
            ecgReport = data.getData();

        }
    }


    public void clinicDUI() {
        bBlood = (Button) findViewById(R.id.ButBlood);
        bUrine = (Button) findViewById(R.id.butUrine);
        bECG = (Button) findViewById(R.id.butECG);
        bEndo = (Button) findViewById(R.id.butEndo);

        bBlood1 = (Button) findViewById(R.id.ButBlood1);
        bUrine1 = (Button) findViewById(R.id.butUrine1);
        bECG1 = (Button) findViewById(R.id.butECG1);
        bEndo1 = (Button) findViewById(R.id.butEndo1);

        tBlood = (TextView) findViewById(R.id.textBlood);
        tUrine = (TextView) findViewById(R.id.textUrine);
        tECG = (TextView) findViewById(R.id.textECG);
        tEndo = (TextView) findViewById(R.id.textEndo);

        progressBarEndoD = (ProgressBar) findViewById(R.id.progressBarEndoD);
        progressBarECGD = (ProgressBar) findViewById(R.id.progressBarECGD);
        progressBarBD = (ProgressBar) findViewById(R.id.progressBarBD);
        progressBarUD = (ProgressBar) findViewById(R.id.progressBarUD);
    }

    //to get extension of file eg .jpeg.jpg
    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mine = MimeTypeMap.getSingleton();
        return mine.getExtensionFromMimeType(cR.getType(uri));

    }

    private void uploadBloodReport(){

        storage = FirebaseStorage.getInstance().getReference("ClinicalReports").child("BloodReport");
        database = FirebaseDatabase.getInstance().getReference("ClinicalReports").child("BloodReport");

        if (Bloodreport != null){
            progressBarBD.setVisibility(View.VISIBLE);
            final StorageReference fileReference = storage.child(System.currentTimeMillis() + "." +getFileExtension(Bloodreport));

            uploadBlood = fileReference.putFile(Bloodreport)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            //delay
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressBarBD.setProgress(0);
                                }
                            },500);
                            progressBarBD.setVisibility(View.GONE);
                            Toast.makeText(clinicalDataD.this, "Uploaded", Toast.LENGTH_SHORT).show();
                            UploadClinicalData upload = new UploadClinicalData(taskSnapshot.getUploadSessionUri().toString());
                            String uploadId = database.push().getKey(); //new entry to db
                            database.child(uploadId).setValue(upload);


                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(clinicalDataD.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                            double progress =(100.0 * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());
                            progressBarBD.setProgress((int) progress);
                        }
                    });

        }else{
            Toast.makeText(clinicalDataD.this,"No file selected",Toast.LENGTH_SHORT).show();
        }

    }

    private void uploadUrineReport(){
        storage = FirebaseStorage.getInstance().getReference("ClinicalReports").child("UrineReport");
        database = FirebaseDatabase.getInstance().getReference("ClinicalReports").child("UrineReport");
        if (urineReport != null){
            progressBarUD.setVisibility(View.VISIBLE);
            StorageReference fileReference = storage.child(System.currentTimeMillis() + "." +getFileExtension(urineReport));

            uploadUrine = fileReference.putFile(urineReport)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            //delay
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressBarUD.setProgress(0);
                                }
                            },5000);
                            progressBarUD.setVisibility(View.GONE);
                            Toast.makeText(clinicalDataD.this, "Uploaded", Toast.LENGTH_SHORT).show();
                            UploadClinicalData upload = new UploadClinicalData(taskSnapshot.getUploadSessionUri().toString());
                            String uploadId = database.push().getKey(); //new entry to db
                            database.child(uploadId).setValue(upload);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(clinicalDataD.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                            double progress =(100.0 * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());
                            progressBarUD.setProgress((int) progress);
                        }
                    });

        }else{
            Toast.makeText(clinicalDataD.this,"No file selected",Toast.LENGTH_SHORT).show();
        }

    }

    private void uploadECGReport(){
        storage = FirebaseStorage.getInstance().getReference("ClinicalReports").child("ECGReports");
        database = FirebaseDatabase.getInstance().getReference("ClinicalReports").child("ECGReports");

        if (ecgReport != null){
            progressBarECGD.setVisibility(View.VISIBLE);
            StorageReference fileReference = storage.child(System.currentTimeMillis() + "." +getFileExtension(ecgReport));

            uploadEcg = fileReference.putFile(endoReport)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            //delay
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressBarECGD.setProgress(0);
                                }
                            },5000);
                            progressBarECGD.setVisibility(View.GONE);
                            Toast.makeText(clinicalDataD.this, "Uploaded", Toast.LENGTH_SHORT).show();
                            UploadClinicalData upload = new UploadClinicalData(taskSnapshot.getUploadSessionUri().toString());
                            String uploadId = database.push().getKey(); //new entry to db
                            database.child(uploadId).setValue(upload);

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(clinicalDataD.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                            double progress =(100.0 * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());
                            progressBarECGD.setProgress((int) progress);
                        }
                    });

        }else{
            Toast.makeText(clinicalDataD.this,"No file selected",Toast.LENGTH_SHORT).show();
        }

    }

    private void uploadEndoReport(){
        storage = FirebaseStorage.getInstance().getReference("ClinicalReports").child("EndoReports");
        database = FirebaseDatabase.getInstance().getReference("ClinicalReports").child("EndoReports");
        if (endoReport != null){
            progressBarEndoD.setVisibility(View.VISIBLE);
            StorageReference fileReference = storage.child(System.currentTimeMillis() + "." +getFileExtension(endoReport));

            uploadEndo = fileReference.putFile(endoReport)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            //delay
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressBarEndoD.setProgress(0);
                                }
                            },5000);
                            progressBarEndoD.setVisibility(View.GONE);
                            Toast.makeText(clinicalDataD.this, "Uploaded", Toast.LENGTH_SHORT).show();
                            UploadClinicalData upload = new UploadClinicalData(taskSnapshot.getUploadSessionUri().toString());
                            String uploadId = database.push().getKey(); //new entry to db
                            database.child(uploadId).setValue(upload);

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(clinicalDataD.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                            double progress =(100.0 * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());
                            progressBarEndoD.setProgress((int) progress);
                        }
                    });

        }else{
            Toast.makeText(clinicalDataD.this,"No file selected",Toast.LENGTH_SHORT).show();
        }

    }
}