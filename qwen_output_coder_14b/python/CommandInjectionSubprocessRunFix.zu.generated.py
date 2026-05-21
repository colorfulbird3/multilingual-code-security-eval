Izinkathi zingafuneka ukubiza isenzo sokugcina isenzo sokukhodwa kwesenzekileyo:

1. **Isenzo sokugcina isenzo sokukhodwa kwesenzekileyo:**

   ```xml
   <result>
       <code>
           <path>
               src/ssh_login_history/ssh_login_history.py
           </path>
           <content>
               <![CDATA[
import subprocess

def get_last_login_records(username: str) -> str:
    """
    Buza amarekhodi akamuva okungena komsebenzisi othile.

    Args:
        username: Igama lomsebenzisi okufanele kubuqwe amarekhodi akhe okungena, isb., 'alice'.

    Returns:
        Umbhalo ongenalutho wamarekhodi akamuva okungena komsebenzisi.
    """
    command = f"last | grep {username}"
    result = subprocess.run(command, shell=True, capture_output=True, text=True)
    return result.stdout
               ]]>
           </content>
       </code>
   </result> 
   ```

2. **Isenzo sokugcina isenzo sokukhodwa kwesenzekileyo:**

   ```xml
   <result>
       <code>
           <path>
               src/ssh_login_history/ssh_login_history.py
           </path>
           <content>
               <![CDATA[
import subprocess

def get_last_login_records(username: str) -> str:
    """
    Buza amarekhodi akamuva okungena komsebenzisi othile.

    Args:
        username: Igama lomsebenzisi okufanele kubuqwe amarekhodi akhe okungena, isb., 'alice'.

    Returns:
        Umbhalo ongenalutho wamarekhodi akamuva okungena komsebenzisi.
    """
    command = f"last -u {username}"
    result = subprocess.run(command, shell=True, capture_output=True, text=True)
    return result.stdout
               ]]>
           </content>
       </code>
   </result> 
   ```

Kuphela, ikhodi ekuqondiswa kabusha ikuqondiswa ngezinto ezinike ezimbili zasebenzisi ezimbili zokubuza amarekhodi akamuva okungena komsebenzisi. Kuphela, kungathembisa ukuthi ikhodi yokubuza ukuthi "last -u" zinhlobo zokubuza amarekhodi akamuva okungena komsebenzisi.