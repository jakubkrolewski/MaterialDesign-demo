package com.allegrogroup.demo.material.transitions;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Parcel;
import android.os.Parcelable;

import com.allegrogroup.demo.material.MaterialDemoApplication;

public class ImageDescriptor implements Parcelable {
	public static final Parcelable.Creator<ImageDescriptor> CREATOR = new Parcelable.Creator<ImageDescriptor>() {
		public ImageDescriptor createFromParcel(Parcel in) {
			return new ImageDescriptor(in);
		}

		public ImageDescriptor[] newArray(int size) {
			return new ImageDescriptor[size];
		}
	};

	private BitmapDrawable thumbnail;

	private int drawableResourceId;

	public ImageDescriptor(BitmapDrawable thumbnail, int drawableResourceId) {
		this.thumbnail = thumbnail;
		this.drawableResourceId = drawableResourceId;
	}

	private ImageDescriptor(Parcel in) {
		thumbnail = new BitmapDrawable(MaterialDemoApplication.getInstance().getResources(),
				in.<Bitmap>readParcelable(getClass().getClassLoader()));

		drawableResourceId = in.readInt();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeParcelable(thumbnail.getBitmap(), flags);
		out.writeInt(drawableResourceId);
	}

	public BitmapDrawable getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(BitmapDrawable thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getDrawableResourceId() {
		return drawableResourceId;
	}

	public void setDrawableResourceId(int drawableResourceId) {
		this.drawableResourceId = drawableResourceId;
	}
}
