package com.example.criminalintent

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import android.net.Uri
import android.widget.ImageView
import java.io.File
import android.provider.MediaStore

import android.graphics.Bitmap
import android.view.Window

class PictureDialogFragment : DialogFragment() {
    private lateinit var photoView: ImageView
    var photoPath = ""

    companion object {
        fun newInstance(photoPath: String): PictureDialogFragment {
            val pictureDialogFragment = PictureDialogFragment()

            val args = Bundle()
            args.putString(PHOTO_PATH, photoPath)
            pictureDialogFragment.arguments = args
            pictureDialogFragment.isCancelable = false
            return pictureDialogFragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        photoPath = arguments?.getString(PHOTO_PATH).toString()
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_picture_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photoView = view.findViewById(R.id.photo_image_view)
            val photoPath =arguments?.getString(PHOTO_PATH)
            val bitmap = photoPath?.let { getScaledBitmap(it, requireActivity()) }
            photoView.setImageBitmap(bitmap)
        }
    }