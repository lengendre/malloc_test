#include <jni.h>
#include <string>
#include <iostream>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_malloc_1test_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */, int count) {
    //std::string hello = "Hello from C++";
    int i = 0;
    while (1) {
        int * p = (int *)malloc(count * 1024 * 1024); // 800M
        //int * p = static_cast<int *>(malloc(80 * 1024 * 1024)); // 8M
        if (p == nullptr) {
            break;
        }
        i++;
    }
    auto s = std::to_string(i);
    return env->NewStringUTF(s.c_str());
}