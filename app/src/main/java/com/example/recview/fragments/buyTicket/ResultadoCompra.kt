package com.example.recview.fragments.buyTicket

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.recview.R
import com.example.recview.entities.Partido
import com.example.recview.entities.Ticket
import com.example.recview.viewmodels.buyTicket.ResultadoCompraViewModel

class ResultadoCompra : Fragment() {

    companion object {
        fun newInstance() = ResultadoCompra()
    }

    private lateinit var viewModel: ResultadoCompraViewModel
    private lateinit var v: View
    private lateinit var goToHomeBtn: Button
    private var resultado = false
    private lateinit var resultadoTitle : TextView
    private lateinit var resultadoTitle2 : TextView
    private lateinit var ticket : Ticket
    private lateinit var partido : Partido

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_resultado_compra, container, false)
        ticket = ResultadoCompraArgs.fromBundle(requireArguments()).ticket
        goToHomeBtn = v.findViewById(R.id.goToHomeBtn)
        resultadoTitle = v.findViewById(R.id.resultadoTitle)
        resultadoTitle2 = v.findViewById(R.id.resultadoTitle2)
        resultado = ResultadoCompraArgs.fromBundle(requireArguments()).resultadoCompra
        partido = ResultadoCompraArgs.fromBundle(requireArguments()).partido
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ResultadoCompraViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()

        if(resultado){
            resultadoTitle.setText(R.string.compraOk)
            resultadoTitle2.setText(R.string.compraOk2)
            goToHomeBtn.setOnClickListener {

                val action = ResultadoCompraDirections.actionResultadoCompraToVentaEntradasFragment()
                v.findNavController().navigate(action)
            }
        }
        else{
            resultadoTitle.setTextColor(resources.getColor(R.color.red))
            resultadoTitle.setText(R.string.compraNotOk)
            with(goToHomeBtn) {
                setText(R.string.compraNotOkBtn)
                setTextColor(resources.getColor(R.color.white))
                setBackgroundColor(resources.getColor(R.color.red))
            }
            goToHomeBtn.setOnClickListener {

                val action = ResultadoCompraDirections.actionResultadoCompraToVentaEntradasFragment()
                v.findNavController().navigate(action)
            }
        }

    }

}