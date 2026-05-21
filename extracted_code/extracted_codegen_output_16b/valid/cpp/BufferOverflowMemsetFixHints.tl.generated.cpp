 bytes na itinakda ay dapat na maiwasan ng pagkopya ng mga lok ng target buffer.
3. Ang bilang ng bytes ay dapat na maiwasan ng pagkopya ng mga lok ng target buffer.
*/

/**
 * @file memory_pool.c
 * @brief memory pool implementation
 */

#ifdef PYTHON
#include <Python.h>
#endif

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "memory_pool.h"

#ifdef PYTHON
PyObject* allocate_pool_memory_py(PyObject* self, PyObject* args) {

    /* Params */
    char* init_data;
    size_t data_len;
    char* pool_buffer;
    size_t pool_size;

    /* Process */
    if (!PyArg_ParseTuple(args, "sss", &init_data, &data_len, &pool_buffer, &pool_size)) {
        PyErr_SetString(PyExc_TypeError, "arguments not valid");
        return NULL;
    }

    /* Call */
    int result = allocate_pool_memory(init_data, data_len, pool_buffer, pool_size);
    if (result!= 0) return Py_BuildValue("i", result);

    /* Return */
    return Py_BuildValue("i", 0);
}

static PyMethodDef allocate_pool_memory_methods[] = {
    {"allocate_pool_memory", allocate_pool_memory_py, METH_VARARGS, "allocate_pool_memory"},
    {NULL, NULL, 0, NULL}
};

#endif

int init_py_module() {

#ifdef PYTHON
    Py_InitModule("memory_pool", allocate_pool_memory_methods);
#endif

    return 0;
}
