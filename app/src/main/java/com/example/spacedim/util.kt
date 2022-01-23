package com.example.spacedim

import androidx.fragment.app.Fragment

/* Définition de la fonction permettant de faire le lien entre plusieurs fragments */
fun Fragment.addChildFragment(fragment: Fragment, frameId: Int) {
    val transaction = childFragmentManager.beginTransaction()
    transaction.replace(frameId, fragment).commit()
}