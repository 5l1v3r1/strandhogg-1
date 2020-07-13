#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_nativeactivity_MainActivity_stringFromJNI(JNIEnv* env,jobject /* this */) {
    std::string hello = "Hey!, this is c++";
    return env->NewStringUTF(hello.c_str());
}
