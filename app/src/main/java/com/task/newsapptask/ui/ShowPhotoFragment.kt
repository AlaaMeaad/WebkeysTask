package com.task.newsapptask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.task.newsapptask.R
import com.task.newsapptask.databinding.FragmentArticleDetailsBinding
import com.task.newsapptask.databinding.FragmentShowPhotoBinding
import uk.co.senab.photoview.PhotoViewAttacher


class ShowPhotoFragment : Fragment() {
    private var _binding: FragmentShowPhotoBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<ShowPhotoFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShowPhotoBinding.inflate(inflater, container, false)
        binding.ivFrgshowPhoto.setOnClickListener {
            val pAttacher: PhotoViewAttacher
            pAttacher = PhotoViewAttacher(binding.ivFrgshowPhoto)
            pAttacher.update()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.article = this.args.article



    }


}