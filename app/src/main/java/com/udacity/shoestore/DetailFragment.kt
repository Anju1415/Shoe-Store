package com.udacity.shoestore


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.models.Shoe

/** onSaveInstanceState Bundle Keys **/

const val NAME = "shoeName"
const val COMPANY="companyName"
const val SIZE="shoeSize"
const val DESCRIPTION="shoeDescription"

class DetailFragment : Fragment() , LifecycleObserver {

    private  lateinit var viewModel :DetailViewModel
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate<FragmentDetailBinding>(inflater, R.layout.fragment_detail, container, false)

        val application = requireNotNull(this.activity).application

        val viewModelFactory = DetailViewModelFactory(application)


        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)
        binding.lifecycleOwner = this



/*
        fun save() {
            if (savedInstanceState != null) {
                val name = savedInstanceState.getString(NAME, "Sport Shoe")
                val company = savedInstanceState.getString(COMPANY, "Adidas")
                val size = savedInstanceState.getString(SIZE, "7")
                val description = savedInstanceState.getString(DESCRIPTION, "Comfortable to wear")

                val shoe: Shoe = Shoe(name!!, size!!, company!!, description!!)
                viewModel.saveCurrentDetail(shoe)
            }
        }*/

        binding.save.setOnClickListener{

            binding.apply {
                shoeDetail?.name = shoeName.text.toString()
                shoeDetail?.company = companyName.text.toString()
                shoeDetail?.size = shoeSize.text.toString()
                shoeDetail?.description = shoeDescription.text.toString()
                //   invalidateAll()

            }
            viewModel.saveCurrentDetail(binding.shoeDetail)
            view?.findNavController()?.navigate(R.id.action_detailFragment_to_collectionFragment)
        }

        binding.cancel.setOnClickListener{

            view?.findNavController()?.navigate(R.id.action_detailFragment_to_collectionFragment)
        }

        return binding.root
    }
/*
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(NAME, binding.shoeName.text.toString())
        outState.putString(SIZE, binding.shoeSize.text.toString())
        outState.putString(COMPANY, binding.companyName.text.toString())
        outState.putString(DESCRIPTION, binding.shoeDescription.text.toString())

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Toast.makeText(context,"Restored",Toast.LENGTH_LONG).show()
    }*/

}