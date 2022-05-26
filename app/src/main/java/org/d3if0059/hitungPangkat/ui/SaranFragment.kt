package org.d3if0059.hitungPangkat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.d3if0059.hitungPangkat.R
import org.d3if0059.hitungPangkat.databinding.FragmentSaranBinding
import org.d3if0059.hitungPangkat.model.SaranHitung

class SaranFragment : Fragment() {
    private lateinit var binding: FragmentSaranBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentSaranBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    private fun updateUI(saran: SaranHitung) {
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        when (saran) {
            SaranHitung.PANGKAT -> {
                actionBar?.title = getString(R.string.judul_saran)
                binding.imageView.setImageResource(R.drawable.saran)
                binding.textView.text = getString(R.string.saran_untukmu)
            }
            SaranHitung.KUADRAT -> {
                actionBar?.title = getString(R.string.judul_saran)
                binding.imageView.setImageResource(R.drawable.saran)
                binding.textView.text = getString(R.string.saran_untukmu)
            }
            SaranHitung.KUBIK -> {
                actionBar?.title = getString(R.string.judul_saran)
                binding.imageView.setImageResource(R.drawable.saran)
                binding.textView.text = getString(R.string.saran_untukmu)
            }
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        updateUI(SaranHitung.PANGKAT)
    }
}

