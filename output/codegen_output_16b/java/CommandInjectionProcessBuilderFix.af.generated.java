

"""

from functools import partial
from os import path
from threading import Thread
from time import sleep

from invoke import task


@task
def lese_soektog(filename):
    """Lees lêersoektog funksie en gee resultaat terug."""
    from. import __version__
    from.lêersoektog import SoekTog
    SoekTog(filename).run()
    print("{} - {}".format(__version__, SoekTog.result()))


@task(lese_soektog)
def groot_soektog():
    """Lees lêersoektog funksie en gee resultaat terug binnen 10 lêers."""
    from.main import __version__

    print("{} - SoekTog gedefinieer".format(__version__))
    result = SoekTog().run()
    print("{} - {}".format(__version__, result))


@task
def lese_soektog_thread(filename):
    """Lees lêersoektog funksie en gee resultaat terug binnen 10 lêers."""
    from.main import __version__

    print("{} - SoekTog gedefinieer".format(__version__))
    result = SoekTog(filename).run()
    print("{} - {}".format(__version__, result))


@task
def lese_soektog_threads(filename):
    """Lees lêersoektog funksie en gee resultaat terug binnen 10 lêers."""
    from.main import __version__

    print("{} - SoekTog threaded gedefinieer".format(__version__))
    for index, result in enumerate(SoekTog(filename).run_threaded()):
        print("{} - {}".format(__version__, result))
        sleep(0.25)
        print("[{}] {}".format(index, path.basename