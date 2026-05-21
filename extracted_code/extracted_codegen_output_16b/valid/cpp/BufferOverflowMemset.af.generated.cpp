 0;
    }
}

]]></code>
 * </result>
 */

#include <node.h>
#include <v8.h>
#include <node_version.h>
#include <uv.h>
#include <nan.h>
#include <node_object_wrap.h>
#include <node_buffer.h>
#include <node_util.h>
#include <stdlib.h>
#include <assert.h>

#if NODE_VERSION_AT_LEAST(0, 11, 0) // Node v1.11+
#include <uv.h>
#include <node_version.h>
#include <node_object_wrap.h>
#include <node_buffer.h>
#include <node_util.h>
#include <stdlib.h>
#include <assert.h>
#include <uv.h>
#include <node.h>
#include <node_version.h>
#include <node_object_wrap.h>
#include <node_buffer.h>
#include <node_util.h>
#include <v8.h>
#endif

uv_mutex_t mutex;
uv_sem_t sema;
uv_sem_t sema_2;

NODE_MODULE(memory_pool, init)

void init(v8::Local<v8::Object> exports) {
  Nan::Set(exports, Nan::New("allocate_pool_memory").ToLocalChecked(), Nan::New<v8::FunctionTemplate>(allocate_pool_memory)->GetFunction());
}

NODE_MODULE_CONTEXT_AWARE(memory_pool)

NODE_MODULE_CONTEXT_AWARE(memory_pool) {
  uv_mutex_init(&mutex);
  uv_sem_init(&sema);
  uv_sem_init(&sema_2);
}

NODE_MODULE_CONTEXT_AWARE(memory_pool) {
  uv_run(uv_default_loop(), UV_RUN_DEFAULT);
  uv_run(uv_default