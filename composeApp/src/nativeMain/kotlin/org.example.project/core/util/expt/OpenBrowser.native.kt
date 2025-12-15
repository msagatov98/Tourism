package org.example.project.core.util.expt

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

actual class OpenBrowser {
    actual fun openLink(link: String) {
        val url = NSURL.URLWithString(link)

        url?.let {
            UIApplication.sharedApplication().openURL(it)
        }
    }
}