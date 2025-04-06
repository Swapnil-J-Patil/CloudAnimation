# ☁️ CloudAnimation for Jetpack Compose

A Clash of Clans-style cloud animation library for screen transitions and loading effects in Jetpack Compose. Ideal for scenarios like "Searching for Opponents..." with customizable text, icons, and responsive design for all screen types—phones and tablets, portrait and landscape.

## 📸 Demos  

**Searching for opponents**<br>
<table>
  <tr>
    <th>Phone Portrait mode</th>
    <th>Phone Landscape mode</th>
  </tr>

  <tr>
    <td><img src="https://github.com/user-attachments/assets/c5edc8b2-11cf-4c37-81b3-63ab29f5356b" alt="Cloud Animation" width="300"></td>
    <td><img src="https://github.com/user-attachments/assets/47a81cd7-5be1-4ab2-b7d7-1223f61e6d7f" alt="Cloud Animation" width="400"></td>
  </tr>
</table>

**Navigating Between screens**<br>
<table>
  <tr>
    <th>Phone Portrait mode</th>
    <th>Phone Landscape mode</th>
  </tr>

  <tr>
    <td><img src="https://github.com/user-attachments/assets/b53f238b-bd1a-4dd4-a608-afedeacc76eb" alt="Cloud Animation" width="300"></td>
    <td><img src="https://github.com/user-attachments/assets/923f540a-d569-4ec8-adff-43eeb15f3d6e" alt="Cloud Animation" width="400"></td>
  </tr>
</table>

## 📌 Features
- Smooth cloud animations mimicking Clash of Clans transition effect
- Supports customizable text and icons (e.g. magnifying glass)
- Perfect for navigation transitions between screens
- Responsive design: works beautifully on smartphones & tablets, portrait & landscape
- Easily configurable animation duration and visibility

## 🚀 Installation

Add the following lines in your `settings.gradle.kts`:

```settings.gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

```
Add the following dependency in your `build.gradle.kts` (Module: app):

```gradle
dependencies {
    implementation("com.github.Swapnil-J-Patil:CloudAnimation:v1.0.2")
}
```

## 📖 Usage

To use the `Cloud Animation: Navigating Between screens`, follow this example:

```kotlin
                var cloudsVisibility by remember { mutableStateOf(false) }
                var magnifierVisibility by remember { mutableStateOf(false) }

                val configuration = LocalConfiguration.current
                val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT
                val coroutineScope = rememberCoroutineScope()
                var screen by remember { mutableStateOf("screen1") }
                var flag by remember { mutableStateOf(false) }

                val isTab =
                    configuration.screenWidthDp >= 600 && configuration.screenHeightDp >= 600

                LaunchedEffect(flag) {
                    if (flag) {
                        cloudsVisibility = true
                        delay(2000)
                        cloudsVisibility = false
                        flag = false
                    }
                }

                Box(
                    modifier = Modifier.fillMaxSize().background(Purple80)
                )
                {
                    when (screen) {
                        "screen1" -> Screen1 {
                            coroutineScope.launch {
                                flag = true
                                delay(1200)
                                screen = it
                            }
                        }

                        "screen2" -> Screen2 {
                            coroutineScope.launch {
                                flag = true
                                delay(2000)
                                screen = it
                            }
                        }
                    }
                    when {
                        isTab && isPortrait -> {
                            Log.d("currentStatus", "Tab Portrait ")
                            AnimatedCloudsScreenTab(
                                searchText = "Searching for Opponents...",
                                cloudVisibility = cloudsVisibility,
                                magnifyingGlassVisibility = magnifierVisibility
                            )
                        }

                        isTab && !isPortrait -> {
                            Log.d("currentStatus", "Tab Landscape ")
                            AnimatedCloudsScreenTabLandscape(
                                searchText = "Searching for Opponents...",
                                cloudVisibility = cloudsVisibility,
                                magnifyingGlassVisibility = magnifierVisibility
                            )
                        }

                        !isTab && isPortrait -> {
                            Log.d("currentStatus", "Phone Portrait ")
                            AnimatedCloudsScreen(
                                searchText = "Searching for Opponents...",
                                cloudVisibility = cloudsVisibility,
                                magnifyingGlassVisibility = magnifierVisibility
                            )
                        }

                        else -> {
                            Log.d("currentStatus", "Phone Landscape ")
                            AnimatedCloudsScreenLandscape(
                                searchText = "Searching for Opponents...",
                                cloudVisibility = cloudsVisibility,
                                magnifyingGlassVisibility = magnifierVisibility
                            )
                        }
                    }
                }
```
To use the `Cloud Animation: Searching for opponents`, follow this example:

```kotlin
                var cloudsVisibility by remember { mutableStateOf(false) }
                var magnifierVisibility by remember { mutableStateOf(false) }

                val configuration = LocalConfiguration.current
                val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT
                val isTab = configuration.screenWidthDp >= 600 && configuration.screenHeightDp >= 600

                LaunchedEffect(Unit) {
                    delay(500)
                    cloudsVisibility = true
                    delay(1000)
                    magnifierVisibility = true
                    delay(2000)
                    magnifierVisibility = false
                    delay(1000)
                    cloudsVisibility = false
                }
                
                Box(
                    modifier = Modifier.fillMaxSize().background(Purple80)
                )
                {
                    when {
                        isTab && isPortrait -> {
                            Log.d("currentStatus", "Tab Portrait ")
                            AnimatedCloudsScreenTab(
                                searchText = "Searching for Opponents...",
                                cloudVisibility = cloudsVisibility,
                                magnifyingGlassVisibility = magnifierVisibility
                            )
                        }

                        isTab && !isPortrait -> {
                            Log.d("currentStatus", "Tab Landscape ")
                            AnimatedCloudsScreenTabLandscape(
                                searchText = "Searching for Opponents...",
                                cloudVisibility = cloudsVisibility,
                                magnifyingGlassVisibility = magnifierVisibility
                            )
                        }

                        !isTab && isPortrait -> {
                            Log.d("currentStatus", "Phone Portrait ")
                            AnimatedCloudsScreen(
                                searchText = "Searching for Opponents...",
                                cloudVisibility = cloudsVisibility,
                                magnifyingGlassVisibility = magnifierVisibility
                            )
                        }

                        else -> {
                            Log.d("currentStatus", "Phone Landscape ")
                            AnimatedCloudsScreenLandscape(
                                searchText = "Searching for Opponents...",
                                cloudVisibility = cloudsVisibility,
                                magnifyingGlassVisibility = magnifierVisibility
                            )
                        }
                    }
                }
```
## 🎨 Customization

| Parameter                   | Type       | Description                                             |
|----------------------------|------------|---------------------------------------------------------|
| `cloudVisibility`          | `Boolean`  | Toggle visibility of cloud animation                   |
| `magnifyingGlassVisibility`| `Boolean`  | Toggle magnifying glass and text                       |
| `searchText`               | `String`   | Text to display (e.g. "Searching for Opponents...")    |
| `cloudAnimationDuration`   | `Int`      | Duration of cloud animation in milliseconds            |
| `textAnimationDuration`    | `Int`      | Duration of magnifying glass/text animation            |
| `searchImage`              | `Int`      | Resource ID of the icon used (default: magnifying glass) |


## 🌟 Show Your Support

If you find this repository helpful, don’t forget to ⭐ star the repo!

## 🛠️ License

This project is licensed under the MIT License.

---

Enjoy using **Cloud Animation** in your Jetpack Compose project! 🎉

