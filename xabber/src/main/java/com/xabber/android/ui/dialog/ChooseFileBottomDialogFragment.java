package com.xabber.android.ui.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xabber.android.R;
import com.xabber.android.presentation.ui.photogallery.ButtonVO;
import com.xabber.android.presentation.ui.photogallery.PhotoGalleryAdapter;
import com.xabber.android.presentation.ui.photogallery.PhotoVO;

import java.util.ArrayList;
import java.util.List;

public class ChooseFileBottomDialogFragment extends BottomSheetDialogFragment implements PhotoGalleryAdapter.Listener {

    private TextView tvCheckedNumber;

    public static ChooseFileBottomDialogFragment newInstance() {
        return new ChooseFileBottomDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bottom_dialog_files, container, false);
        RecyclerView rvFiles = view.findViewById(R.id.rvFiles);
        tvCheckedNumber = view.findViewById(R.id.tvCheckedNumber);

        List<PhotoVO> items = new ArrayList<>();
        items.add(new ButtonVO("test"));
        for (int i = 0; i < 50; i++) {
            items.add(new PhotoVO("test"));
        }
        PhotoGalleryAdapter adapter = new PhotoGalleryAdapter(items, getActivity(), this);

        rvFiles.setAdapter(adapter);
        rvFiles.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        return view;
    }

    @Override
    public void onItemsChecked(int numberOfChecked) {
        if (numberOfChecked > 0)
            tvCheckedNumber.setText(numberOfChecked + " photo selected");
        else tvCheckedNumber.setText("Select photo for sending:");
    }
}