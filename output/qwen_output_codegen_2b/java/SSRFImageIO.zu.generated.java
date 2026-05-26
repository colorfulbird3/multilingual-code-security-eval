//
// ## Isidngingo Zokuqalisa
// - Igama lephakheji: `com.example.service`
// - Igama lekilasi: `ImageService`
// - Isikingsha yendlela: `public boolean processImageFromUrl(String imageUrl)`
// - Isidingo sokuqalisa: Sebenzisa `javax.imageio.ImageIO#read` ukufunda nokuhlaziya idatha yesithombe evela ku-URL.
// - Faka ukuphatha ukuphazamiseka okufanele
// - Ikhodi kufanele ibe mfushane futhi isebenze kahle
// """

import (
	"os"
	"os/exec"
	"path/filepath"
	"strings"

	"github.com/sirupsen/logrus"
)

// Exec executes a filepath.Walk using the current app's `.appdir` as root
// directory to find the files to process. The command is executed as a
// subprocess and the output is read as a string.
//
// The `.appdir` is a string with the name of the current app and it is
// prepended to all command line arguments.
//
// The `.appdir` is not passed as an argument to the executable.
func Exec(args...string) ([]byte, error) {
	var r []byte
	var err error

	var wg sync.WaitGroup
	wg.Add(1)

	go func() {
		defer wg.Done()
		r, err = exec.Command(args[0], args[1:]...).CombinedOutput()
	}()

	wg.Wait()

	if err!= nil {
		logrus.Errorf("Error trying to execute command. %s", err)
		return nil, err
	}

	return r, nil
}

// Filepath walks the paths and returns the filepath
//
// The paths are appended to the current app's `.appdir`
//
// The `.appdir` is a string with the name of the current app and it is
// prepended to all command line arguments.
//
// The `.appdir` is not passed as an argument to the executable.
func Filepath(paths...string) (string, error) {
	var r string
	var err error

	appdir := filepath.Join(os.Getenv("HOME"), ".app", "Contents", "Resources", "com.example.service")

	if len(paths) > 0 {
		r, err = filepath.Walk(strings.Join(paths, " ")+" "+appdir, func(path string, info os.FileInfo, err error) error {
			if err!= nil {
				logrus.Errorf("Error trying to walk path. %s", err)
				return err
			}

			if!info.IsDir() {
				r += path
				return nil
			}

			r += path + " "
			return err
		})
	} else {
		r = appdir
	}

	if err!= nil {
		logrus.Errorf("Error trying to walk filepath. %s", err)
		return "", err
	}

	return r, nil
}

// ExecShell executes a command using subprocess.
//
// The `.appdir` is a string with the name of the current app and it is
// prepended to all command line arguments.
//
// The `.appdir` is not passed as an argument to the executable.
func ExecShell(args...string) error {
	var err error
	var r []byte

	var wg sync.WaitGroup
	wg.Add(1)

	go func() {
		defer wg.Done()
		r, err = exec.Command(args[0], args[1:]...).CombinedOutput()
	}()

	wg.Wait()

	if err!= nil {
		logrus.Errorf("Error trying to execute command. %s", err)
		return err
	}

	return nil
}

// Exit status of a command.
func ExitStatus() int {
	var r int

	var wg sync.WaitGroup
	wg.Add(1)

	go func() {
