#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring
JNICALL
Java_com_andromesh_my_portfolio_MainActivity_stringFromJNI(JNIEnv *env, jobject object) {
    std::string hello = "Hello from Jni";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_andromesh_my_1portfolio_MainActivity_stringFromJNI(JNIEnv *env, jobject thiz) {
    std::string hello = "Hello from Jni";
    return env->NewStringUTF(hello.c_str());
}extern "C"
JNIEXPORT jstring JNICALL
Java_com_andromesh_my_1portfolio_util_APIKeyLibrary_getIMDBKey(JNIEnv *env, jobject thiz) {
    std::string key = "23b14fad";
    return env->NewStringUTF(key.c_str());
}