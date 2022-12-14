package com.example.recview.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.recview.R
import com.example.recview.viewmodels.miPerfil.MiPerfilViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MiPerfilFragment : Fragment() {


    lateinit var v :                    View
    lateinit var btnCarnet :            Button
    lateinit var btnMisEntradas :       Button
    lateinit var btnMisPagos :          Button
    lateinit var btnHaceteSocio :       Button
    lateinit var btnComprarEntrada :    Button
    lateinit var btnInstagram :         Button
    lateinit var btnTiendVirtual :      Button
    lateinit var btnCerrarSesion :      Button
    lateinit var InfoYNovedades:        Button



    companion object {
        fun newInstance() = MiPerfilFragment()
    }

    private lateinit var viewModel: MiPerfilViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        v =                 inflater.inflate(R.layout.fragment_mi_perfil, container, false)
        btnCarnet =         v.findViewById(R.id.btnMiPerfilToCarnet)
        btnMisEntradas =    v.findViewById(R.id.btnMiPerfilToMisEntradas)
        btnMisPagos =       v.findViewById(R.id.btnMiPerfilToMisPagos)
        btnHaceteSocio =    v.findViewById(R.id.btnMiPerfilToHaceteSocio)
        btnComprarEntrada = v.findViewById(R.id.btnMiPerfilToComprarEntrada)
        btnInstagram=       v.findViewById(R.id.btnMiPerfilToInstagram)
        btnTiendVirtual=    v.findViewById(R.id.btnMiPerfilToTiendaVirtual)
        btnCerrarSesion=    v.findViewById(R.id.btnMiPerfilToCerrarSesion)
        InfoYNovedades =    v.findViewById(R.id.btnMiPerfilToInfoYNovedades)


        return v
    }

    override fun onStart() {
        super.onStart()

        btnCerrarSesion.setOnClickListener {
            Firebase.auth.signOut()
            val action = MiPerfilFragmentDirections.actionMiPerfilFragmentToLoginActivity()
            v.findNavController().navigate(action)
        }

        InfoYNovedades.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://velez.com.ar/futbol")
            startActivity(openURL)
        }

        btnCarnet.setOnClickListener {
            val action = MiPerfilFragmentDirections.actionMiPerfilFragmentToCarnetFragment()
            v.findNavController().navigate(action)

        }
        btnMisEntradas.setOnClickListener {
            val action = MiPerfilFragmentDirections.actionMiPerfilFragmentToMisEntradasFragment()
            v.findNavController().navigate(action)

        }

        btnMisPagos.setOnClickListener {
            val action = MiPerfilFragmentDirections.actionMiPerfilFragmentToMisPagosFragment()
            v.findNavController().navigate(action)

        }

        btnHaceteSocio.setOnClickListener {
            val action = MiPerfilFragmentDirections.actionMiPerfilFragmentToHaceteSocioFragment()
            v.findNavController().navigate(action)

        }

        btnComprarEntrada.setOnClickListener {
            val action = MiPerfilFragmentDirections.actionMiPerfilFragmentToVentaEntradasFragment()
            v.findNavController().navigate(action)
        }
        btnInstagram.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.instagram.com/velez/")
            startActivity(openURL)
        }

        btnTiendVirtual.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.tiendavelez.com.ar/")
            startActivity(openURL)
        }

    }



}