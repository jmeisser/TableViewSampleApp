package com.evrencoskun.tableviewsample2.fragmentnav;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.chopshopscout2023.R;
import com.example.chopshopscout2023.databinding.MatchInfoFragmentBinding;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRScanFragment extends Fragment {

    private PageViewModel pageViewModel;
    private MatchInfoFragmentBinding binding;
    //private Camera camera;

    public static QRScanFragment newInstance() {
        QRScanFragment infoFragment = new QRScanFragment();
        Bundle bundle = new Bundle();
        //bundle.putInt(ARG_SECTION_NUMBER, index);
        infoFragment.setArguments(bundle);
        return infoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = MatchInfoFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //EditText editText = getView().findViewById(R.id.editText);
        //ImageView imageView = getView().findViewById(R.id.imageView);
        //Button btn = getView().findViewById(R.id.btn);
        Button btn2 = getView().findViewById(R.id.scanQR);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // we need to create the object
                // of IntentIntegrator class
                // which is the class of QR library
                IntentIntegrator integrator = IntentIntegrator.forSupportFragment(QRScanFragment.this);

                integrator.setOrientationLocked(false);
                integrator.setPrompt("Scan QR code");
                integrator.setBeepEnabled(false);

                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);


                integrator.initiateScan();
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //TextView messageText = getView().findViewById(R.id.textContent);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_LONG).show();
            } else {

                Toast.makeText(getContext(), "Scanned : " + result.getContents(), Toast.LENGTH_LONG).show();
                String matchDataString = result.getContents();
                //messageText.setText(matchDataString);


            }
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}