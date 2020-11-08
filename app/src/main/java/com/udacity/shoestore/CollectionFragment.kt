package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentCollectionBinding

class CollectionFragment : Fragment() {
    private lateinit var binding: FragmentCollectionBinding

    //private lateinit var model: DetailViewModel
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentCollectionBinding>(inflater, R.layout.fragment_collection, container, false)

        setHasOptionsMenu(true)

        binding.fab.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_collectionFragment_to_detailFragment)
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(DetailViewModel::class.java)

        binding.lifecycleOwner = this

        model.shoes.observe(viewLifecycleOwner, Observer { list ->
            //  Toast.makeText(context,"$list", Toast.LENGTH_LONG).show()
            val adapter = ShoeAdapter(list)
            binding.list.adapter = adapter
        })

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.collectionTitle)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


}