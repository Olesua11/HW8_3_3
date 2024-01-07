package com.example.hw8_3_3
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw8_3_3.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding:FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val person = arguments?.getSerializable("person") as Person

        binding.tvName.text = person.name
        binding.tvStatus.text = person.status
        binding.ivPoster.loadImage(person.img)
    }
}