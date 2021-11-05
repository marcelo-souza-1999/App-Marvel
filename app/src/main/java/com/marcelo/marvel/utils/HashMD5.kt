package com.marcelo.marvel.utils

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

object HashMD5 {

    fun convertMD5(hashs: String): String {

        lateinit var getHash: String

        try {
            val digest = MessageDigest.getInstance("MD5")
            digest.update(hashs.toByteArray())
            val messageDigest = digest.digest()

            val hexString = StringBuilder()
            for (aMessageDigest in messageDigest) {
                var hash = Integer.toHexString(0xFF and aMessageDigest.toInt())
                while (hash.length < 2)
                    hash = "0$hash"
                hexString.append(hash)
            }
            getHash = hexString.toString()

        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        return getHash
    }
}