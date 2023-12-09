/*
 * Copyright 2023. All rights reserved.
 * Dissemination of this information or reproduction of this material is strictly forbidden
 * unless prior written permission is obtained from Divya N.
 *
 * Created by Divya N
 */

package com.groupal.design.utils

import android.app.Activity
import android.content.Intent
import android.view.View

fun Activity.closeActivity() {
    finish()
}

fun Activity.startAppActivity(c: Class<*>) {
    val intent = getIntent(c, IntentType.DEFAULT)
    launchIntent(intent)
}

fun Activity.startAppActivityClear(c: Class<*>) {
    val intent = getIntent(c, IntentType.CLEAR_TASK)
    launchIntent(intent)
    finishAffinity()
}

fun Activity.launchIntent(intent: Intent) {
    startActivity(intent)
}

fun Activity.getIntent(c: Class<*>, @IntentType intentType: Int): Intent {
    val intent = Intent(this, c)
    when (intentType) {

        IntentType.SINGLE_TOP -> intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or
                Intent.FLAG_ACTIVITY_SINGLE_TOP or
                Intent.FLAG_ACTIVITY_CLEAR_TOP

        IntentType.CLEAR_TASK -> {
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        IntentType.DEFAULT -> {
        }
    }
    return intent
}

fun View.hide() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}

