package com.task.newsapptask.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.task.newsapptask.databinding.FragmentArticleDetailsBinding
import com.task.newsapptask.listeners.ArticleDetailsListeners
import android.content.Intent
import android.net.Uri
import androidx.navigation.NavAction
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.task.newsapptask.R
import kotlinx.android.synthetic.main.activity_main.*


class ArticleDetailsFragment : Fragment(), ArticleDetailsListeners {
    private var _binding: FragmentArticleDetailsBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<ArticleDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentArticleDetailsBinding.inflate(inflater, container, false)
        binding.ivBack.setOnClickListener {
            findNavController().navigate(R.id.action_articleDetailsFragment_to_newsListFragment)
        }
        binding.ivShare.setOnClickListener {
            var link :String = args.article.url.toString()
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, link);
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
        binding.ivPhoto.setOnClickListener {

            val action = ArticleDetailsFragmentDirections.actionArticleDetailsFragmentToShowPhotoFragment(args.article)
            findNavController().navigate(action)

        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listener = this
        binding.article = this.args.article



    }

    override fun onReadMoreClicked(view: View, url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }


}