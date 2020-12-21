#include <jni.h>
#include <cstdlib>
#include <cstring>


extern "C"
JNIEXPORT jstring JNICALL
Java_id_ac_ui_cs_mobileprogramming_muhammad_1ardivan_1satrio_1nugroho_sadboiapp_ui_activity_MainActivity_greeting(
        JNIEnv *env, jobject thiz) {

    return env->NewStringUTF("Hello welcome to SadBoi App!");
}