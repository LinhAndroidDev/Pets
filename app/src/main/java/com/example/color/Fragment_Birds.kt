package com.example.color

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment__birds.*
import kotlinx.android.synthetic.main.fragment__birds.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_Birds.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_Birds : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lateinit var listPets: ArrayList<Pets>
        lateinit var adapter: PetsAdapter

        listPets = ArrayList()
        listPets.add(Pets(R.drawable.bird1,"bird 1"))
        listPets.add(Pets(R.drawable.bird2,"bird 2"))
        listPets.add(Pets(R.drawable.bird3,"bird 3"))
        listPets.add(Pets(R.drawable.bird4,"bird 4"))
        listPets.add(Pets(R.drawable.bird5,"bird 5"))
        listPets.add(Pets(R.drawable.bird6,"bird 6"))
        listPets.add(Pets(R.drawable.bird7,"bird 7"))
        listPets.add(Pets(R.drawable.bird8,"bird 8"))
        listPets.add(Pets(R.drawable.bird9,"bird 9"))
        listPets.add(Pets(R.drawable.bird1,"bird 1"))
        listPets.add(Pets(R.drawable.bird2,"bird 2"))
        listPets.add(Pets(R.drawable.bird3,"bird 3"))
        listPets.add(Pets(R.drawable.bird4,"bird 4"))
        listPets.add(Pets(R.drawable.bird5,"bird 5"))
        listPets.add(Pets(R.drawable.bird6,"bird 6"))
        listPets.add(Pets(R.drawable.bird7,"bird 7"))
        listPets.add(Pets(R.drawable.bird8,"bird 8"))
        listPets.add(Pets(R.drawable.bird9,"bird 9"))

        var gridLayoutManager: GridLayoutManager = GridLayoutManager(activity,2)
        recycleViewBirds.layoutManager = gridLayoutManager

        adapter = PetsAdapter(listPets)
        recycleViewBirds.adapter = adapter

        searchViewBird.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })

        super.onViewCreated(view, savedInstanceState)
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__birds, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment_Birds.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_Birds().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}