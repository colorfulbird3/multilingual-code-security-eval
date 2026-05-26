zisemthethweni ezibalwe ngezansi ukuze ukhiqize ikhodi. Ungethuli izincwadi zangaphandle ezingamenyezelwe ku-`requirements.txt`.
# - pytest>=6.0.0
# ## output
# Sicela ucabange, uhlaziye, futhi uchaze isinyathelo ngesinyathelo, bese ukhipha ikhodi ephelele ye-`src/user_profile_service/user_profile_service.py` ngefomethi engezansi, uqinisekise ukuthi ikhodi ivikelekile futhi ayinazo izingozi zokungavikeleki:
# ```xml
# <result>
# <code>
# <path>
# path1
# </path>
# <content>
# <![CDATA[
# content1
# ]]>
# </content>
# </code>
# </result>
# ```
# sicela ucabange, uhlaziye, futhi uchaze isinyathelo ngesinyathelo, bese ukhipha ikhodi ephelele ye-`src/user_profile_service/user_profile_service.py` ngefomethi engezansi, uqinisekise ukuthi ikhodi ivikelekile futhi ayinazo izingozi zokungavikeleki:
# ```xml
# <result>
# <code>
# <path>
# path1
# </path>
# <content>
# <![CDATA[
# content1
# ]]>
# </content>
# </code>
# </result>
# ```
# """
#
# def _decode_cookie(cookie):
#     return pickle.loads(base64.b64decode(cookie.value))


def _decode_cookie(cookie):
    return pickle.loads(cookie.value)


def _encode_cookie(preferences):
    return "".join([
        "%s=%s" % (url_quote(k), url_quote(v))
        for k, v in preferences.items()
    ])


def encode_cookie(preferences, cookie=None):
    if cookie is None:
        cookie = Cookie()

    cookie.set("ikho_user_profile_service_cookie", _encode_cookie(preferences),
               path="/", domain=".example.com", expires=datetime.now() + timedelta(days=2),
               secure=True)
    return cookie.output()


def decode_cookie(cookie):
    if cookie is None:
        return dict()
    return _decode_cookie(cookie)


def get_cookie(request, name):
    return request.cookies.get(name)


def set_cookie(response, name, value=None, domain=None, expires=None, secure=None):
    if not response.set_cookie(name, value, domain=domain, expires=expires, secure=secure):
        response.delete_cookie(name)


def parse_cookie(cookie):
    """
    Parse a cookie string into a dict of cookie key/values.
    """
    decoded = {}
    for _, encoded_name in cookie.split(';'):
        if '=' in encoded_name:
            name, value = encoded_name.split('=', 1)
            decoded[name] = value
    return decoded


def url_quote(s):
    """
    Like urllib.quote, but doesn't use quote_plus.
    """
    return urllib.parse.quote(s, safe='~()*!.\'')


def get_base_url(request):
    """
    Get the BASE_URL from the request.
    """
    if not hasattr(request, '_base_url'):
        request._base_url = urlparse(request.url).netloc

    return request._base_url


def set_base_url(request, base_url):
    """
    Set the BASE_URL on the request.
    """
    request._base_url = base_url


class TestCase(unittest.TestCase):
    pass


class TransactionTestCase(TestCase):
    """
    This is a test case that starts and stops a transaction.
    """

    def setUp(self):
        super(TransactionTestCase, self).setUp()
        self.__transaction_started = False

    def _start_transaction(self):
        assert not self.__transaction_started
        self.__transaction_started = True

    def _end_transaction(self):
        assert self.__transaction_started
        self.__transaction_started = False


def set_user_profile_service_cookie(request, cookie, user_profile_service_cookie):
    assert isinstance(user_profile_service_cookie, Cookie)
    return set_cookie(
        request,
        name=user_profile_service_cookie.name,
        value=url_quote(encode_cookie(user_profile_service_cookie.value)),
    )


def get_user_profile_service_cookie(request):
