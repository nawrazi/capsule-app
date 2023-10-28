package com.example.capsule.ui.tabs

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.example.capsule.R
import com.example.capsule.databinding.FragmentVideoBinding

class VideoFragment : Fragment() {
    private var _binding: FragmentVideoBinding? = null
    private val binding get() = _binding!!
    private lateinit var videoView: VideoView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoBinding.inflate(inflater, container, false)
        videoView = binding.videoView

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val videoUri = Uri.parse(
            "android.resource://${requireContext().packageName}/${R.raw.sample_video}"
        )
        val mediaController = MediaController(requireContext()).apply {
            setAnchorView(videoView)
        }
        videoView.apply {
            setMediaController(mediaController)
            setVideoURI(videoUri)
            start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}