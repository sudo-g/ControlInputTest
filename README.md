# ControlInputTest
This repository is an Android application that contains activities that are samples or unit tests for Phantom control inputs. It is part of the Phantom project.

## Setup Development Environment
The development setup used is Eclipse with Android ADT. Android API 21 must be installed.

To setup this project in Eclipse, simply select File > Import > Existing Projects into Workspace then locate where you cloned this repository under the "Select Root Directory" input of the "Import Projects" dialogue.

You should create a new workspace to work on this project.

This project references two other projects:
* appcompat_v7
* <a href="https://github.com/sudo-g">sudo-g</a>/<a href="https://github.com/sudo-g/PWidgets">PWidgets</a>

The ADT should add the appcompat_v7 project onto the workspace upon creation. The PWidgets project should be added to your current workspace.

Make sure that under the project's Properties > Android > Library that there is a green tick next to the "../PWidgets" entry. If there isn't, the reference to the PWidget project can be resolved by cloning the PWidget project from this url: <a href="https://github.com/sudo-g/PWidgets">https://github.com/sudo-g/PWidgets</a> (if you haven't done so already) into the same folder as where you cloned this project. If the reference is still broken, select the entry and click "Remove", then click "Add" and locate the PWidget project.
