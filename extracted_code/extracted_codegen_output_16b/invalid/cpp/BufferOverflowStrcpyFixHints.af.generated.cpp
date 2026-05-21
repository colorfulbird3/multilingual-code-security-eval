from django.contrib.auth.decorators import login_required, permission_required
from django.http.response import HttpResponse
from functools import wraps


def store_api_key(f):
    """
    This decorator stores an API-key and user-info in a key-store and
    returns an identifier.

    """
    @wraps(f)
    def store_api_key_wrapper(request, *args, **kwargs):
        ret = f(request, *args, **kwargs)
        # TODO: only return the hash if the user has permissions to store
        # the key.
        return HttpResponse(ret)
    return store_api_key_wrapper


@login_required
def retrieve_api_key(request, identifier):
    """
    This decorator retrieves the API-key and user-info from the key-store and
    returns the combined string.

    """
    ret = "API-key not found."
    try:
        ret = "API-key: %s, User: %s" % (key_store[identifier].key,
                                         key_store[identifier].user)
    except KeyError:
        pass
    return HttpResponse(ret)