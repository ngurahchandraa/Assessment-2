package org.d3if0059.hitungPangkat.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import org.d3if0059.hitungPangkat.R
import org.d3if0059.hitungPangkat.databinding.FragmentHitungBinding
import org.d3if0059.hitungPangkat.model.HasilHitungAkar
import org.d3if0059.hitungPangkat.model.HasilHitungKubik
import org.d3if0059.hitungPangkat.model.HasilHitungPangkat

class HitungFragment : Fragment() {

    private lateinit var binding: FragmentHitungBinding
    private val viewModel: HitungViewModel by lazy {
        ViewModelProvider(requireActivity())[HitungViewModel::class.java]
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_about) {
            findNavController().navigate(
                R.id.action_hitungFragment_to_aboutFragment)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        binding.saranButton.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_hitungFragment_to_saranFragment
            )
        }
        binding.shareButton.setOnClickListener { shareData() }

        binding.button.setOnClickListener { hitungPangkat() }
        binding.buttonKuadrat.setOnClickListener { hitungAkarKuadrat() }
        binding.buttonKubik.setOnClickListener { hitungAkarKubik() }
        binding.buttonClear.setOnClickListener { clearButton() }
        return binding.root
    }

    private fun hitungPangkat() {
        val angka = binding.angkaInp.text.toString()
        if (TextUtils.isEmpty(angka)) {
            Toast.makeText(context, R.string.angka_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val pangkat = binding.pangkatInp.text.toString()
        if (TextUtils.isEmpty(pangkat)) {
            Toast.makeText(context, R.string.pangkat_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val result = viewModel.hitungPangkat(
            angka.toFloat(),
            pangkat.toFloat(),
        )
        showResult(result)

    }

    private fun showResult(result: HasilHitungPangkat) {
        binding.hasilTextView.text = getString(R.string.hitungPangkat_x, result.pangkat)
    }


    private fun hitungAkarKuadrat() {
        val angkaAkar = binding.angkaAkarInp.text.toString()
        if (TextUtils.isEmpty(angkaAkar)) {
            Toast.makeText(context, R.string.angka_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val result = viewModel.hitungPangkatKuadrat(
            angkaAkar.toFloat(),
        )
        showResult(result)
    }

    private fun showResult(result: HasilHitungAkar) {
        binding.hasilAkarTextView.text = getString(R.string.hitungAkar_x, result.akar)
    }

    private fun hitungAkarKubik() {
        val angkaKubik = binding.angkaAkarInp.text.toString()
        if (TextUtils.isEmpty(angkaKubik)) {
            Toast.makeText(context, R.string.angka_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val result = viewModel.hitungPangkatKubik(
            angkaKubik.toFloat(),
        )
        showResult(result)
    }

    private fun showResult(result: HasilHitungKubik) {
        binding.hasilAkarTextView.text = getString(R.string.hitungAkar_x, result.kubik)
    }

    private fun shareData() {

        val message = getString(R.string.bagikan_template,
        )
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
    }


    private fun clearButton() {

    }

}