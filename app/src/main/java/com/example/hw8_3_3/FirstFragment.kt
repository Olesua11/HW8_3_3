package com.example.hw8_3_3
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hw8_3_3.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val personList = arrayListOf(
        Person("https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest?cb=20160923150728", "Rick Sanchez", "Alive"),
        Person("https://static.tvtropes.org/pmwiki/pub/images/morty_smith_2.png", "Morty Smith", "Alive"),
        Person("https://static.wikia.nocookie.net/rickandmorty/images/b/bc/Albert_Einstein.png/revision/latest?cb=20150730213810", "Albert Einstein", "Dead"),
        Person("https://static.wikia.nocookie.net/ricksanchez/images/f/f6/Jerry_Smith.jpg/revision/latest?cb=20160609043244", "Jerry Smith", "Alive")
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PersonAdapter(personList, this::onClick)
        binding.rvPerson.adapter = adapter
    }

    private fun onClick(position: Int){
        val person = personList[position]
        findNavController().navigate(R.id.secondFragment, bundleOf("person" to person))
    }
}