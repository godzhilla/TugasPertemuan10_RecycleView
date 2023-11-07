package com.example.tugaspertemuan10_recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugaspertemuan10_recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        with(binding){
            rvMahasiswa.apply { 
                adapter = ListAdapter(listListModel = generateMahasiswa(), onClickList = {kinan ->
                    Toast.makeText(
                        this@MainActivity,
                        "${kinan.nama}, TRPL ${kinan.nim[0]}${kinan.nim[1]}",
                        Toast.LENGTH_SHORT
                    ).show()} )

                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    private fun generateMahasiswa(): List<ListModel> {
        return listOf(
            ListModel(R.drawable.bastian, "Bastian Lentera Dunia", "19/111111/NCIT/10001", 3.7),
            ListModel(R.drawable.brian_hermawan, "Brian Hermawan", "23/207219/NCIT/29087", 3.8),
            ListModel(R.drawable.dikta_dan_hukum, "Dikta Dan Hukum", "19/111235/NCIT/10011", 4.0),
            ListModel(R.drawable.giyan_hermawan, "Giyan Hermawan", "21/200421/NCIT/25977", 3.4),
            ListModel(R.drawable.jehian_pangabean, "Jehian Pangabean", "21/200371/NCIT/25890", 3.2),
            ListModel(R.drawable.jeremy_alejandro, "Jeremy Alejandro", "19/115210/NCIT/11762", 3.6),
            ListModel(R.drawable.jonathan_nathaniel, "Jonathan Nathaniel", "19/112981/NCIT/10421", 2.9),
            ListModel(R.drawable.junior_hakim, "Junior Hakim", "20/207836/NCIT/19978", 3.4),
            ListModel(R.drawable.lentera_mustofa, "Lentera Mustofa", "18/100711/NCIT/09781", 3.0),
            ListModel(R.drawable.mahesa_christian, "Mahesa Christian", "20/290078/NCIT/20089", 3.5),
            ListModel(R.drawable.marco_kaya_raya, "Marco Kaya Raya", "23/207991/NCIT/20767", 4.0)
            )

    }
}