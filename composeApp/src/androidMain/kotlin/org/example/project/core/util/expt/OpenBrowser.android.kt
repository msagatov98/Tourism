package org.example.project.core.util.expt

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.widget.Toast
import androidx.core.net.toUri

actual class OpenBrowser(
    private val context: Context
) {

    actual fun openLink(link: String) {
        try {
            val browserIntent = Intent(Intent.ACTION_VIEW, link.toUri()).apply {
                setFlags(FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(browserIntent)
        } catch (e: Exception) {
            Toast.makeText(context, e.localizedMessage ?: e.message, Toast.LENGTH_SHORT).show()
        }
    }
}