package com.allegrogroup.demo.material.transitions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.transition.Explode;
import android.widget.ImageView;

import com.allegrogroup.demo.material.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoTools;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TransitionsBigGalleryActivity extends Activity {
	private final static String EXTRA_IMAGE_DESCRIPTORS_LIST = "imageDescriptorsList";

	@InjectView(R.id.image1)
	ImageView image1;

	@InjectView(R.id.image2)
	ImageView image2;

	public static Intent createIntent(Context context, ImageDescriptor imageDescriptor1, ImageDescriptor imageDescriptor2) {
		ArrayList<Parcelable> imageDescriptorsList = new ArrayList<Parcelable>(Arrays.asList(imageDescriptor1, imageDescriptor2));

		return new Intent(context, TransitionsBigGalleryActivity.class)
				.putParcelableArrayListExtra(EXTRA_IMAGE_DESCRIPTORS_LIST, imageDescriptorsList);
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setEnterTransition(new Explode());
        getWindow().setAllowEnterTransitionOverlap(true);

        setContentView(R.layout.activity_transitions_b);

		ButterKnife.inject(this);

		loadImagesFromExtras();
    }

	private void loadImagesFromExtras() {
		ArrayList<ImageDescriptor> imageDescriptorsList = getIntent().getParcelableArrayListExtra(EXTRA_IMAGE_DESCRIPTORS_LIST);

		loadImages(imageDescriptorsList);
	}

	private void loadImages(ArrayList<ImageDescriptor> imageDescriptorsList) {
		Picasso picasso = Picasso.with(this);

		PicassoTools.clearCache(picasso);

		picasso
				.load(imageDescriptorsList.get(0).getDrawableResourceId())
				.placeholder(imageDescriptorsList.get(0).getThumbnail())
				.fit()
				.centerInside()
				.into(image1);

		picasso
				.load(imageDescriptorsList.get(1).getDrawableResourceId())
				.placeholder(imageDescriptorsList.get(1).getThumbnail())
				.fit()
				.centerInside()
				.into(image2);
	}
}
