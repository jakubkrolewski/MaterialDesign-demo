package com.allegrogroup.demo.material.transitions;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

import com.allegrogroup.demo.material.R;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class TransitionsSmallGalleryActivity extends Activity {

	@InjectView(R.id.imageSmall1)
	ImageView smallImage1;

	@InjectView(R.id.imageSmall2)
	ImageView smallImage2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().setAllowExitTransitionOverlap(true);

		setContentView(R.layout.activity_transitions_a);

		ButterKnife.inject(this);

		loadImages();
	}

	private void loadImages() {
		Picasso picasso = Picasso.with(this);

		picasso
				.load(R.drawable.cat_hat)
				.fit()
				.centerInside()
				.into(smallImage1);

		picasso
				.load(R.drawable.cat_hat2)
				.fit()
				.centerInside()
				.into(smallImage2);
	}

	@OnClick(R.id.bigGallery)
	void onBigGalleryButtonClick() {
		startActivity(createBigGalleryIntent());
	}

	@OnClick(R.id.imagesPanel)
	void onImagesPanelClicked() {
		Intent intent = createBigGalleryIntent();

		ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,
				Pair.<View, String>create(smallImage1, smallImage1.getViewName()),
				Pair.<View, String>create(smallImage2, smallImage2.getViewName()));

		// or: options = ActivityOptions.makeSceneTransitionAnimation(this, smallImage1, smallImage1.getViewName());

		startActivity(intent, options.toBundle());
	}

	private Intent createBigGalleryIntent() {
		return TransitionsBigGalleryActivity.createIntent(this,
				new ImageDescriptor((BitmapDrawable) smallImage1.getDrawable(), R.drawable.cat_hat),
				new ImageDescriptor((BitmapDrawable) smallImage2.getDrawable(), R.drawable.cat_hat2));
	}
}
