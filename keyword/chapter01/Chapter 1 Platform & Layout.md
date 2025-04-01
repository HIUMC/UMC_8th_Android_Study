# Chapter 1. Platform & Layout

---

<aside>
💡 **워크북 가이드라인**
1️⃣ 키워드 Essential은 자기주도학습!
2️⃣ 미션 수행하면서 트러블 슈팅 과정을 꼭! 정리해서 팀원들과 공유해보세요!
3️⃣ 주차별 Esssential은 권장이 아니라 필독입니다~
4️⃣ Essential에서 자세히 다루지 않은 내용은 레퍼런스 확인하셔서 살을 붙이시면 됩니다!

</aside>

---

---

## 📝 학습 목표

---

- Platform에 대해서 설명할 수 있다.
- Android의 개발 방식과 Layout에 대해 설명할 수 있다.

## ⚠️ 스터디 진행 방법

---

1. 스터디를 진행하기 전, 워크북 내용들을 모두 채우고 서로 모르는 내용들을 공유해주세요.
2. 미션을 모두 진행하시고 파트장 분께서 스터디원들의 코드 리뷰를 진행해주세요.
3. 다음주 스터디를 진행하기 전, 파트장의 간략한 설명을 듣고 개념의 윤곽을 잡아보세요.

## ✨ 파트장이 남기는 말

---

이번 주차에서는 안드로이드의 구성요소를 중심으로 공부합니다. 본격적으로 Activity와 Fragment를 다루기 전에 안드로이드 개발이 어떤 방식으로 흘러가는지 흐름을 느끼시는 챕터라고 생각하시면 됩니다.

한 번 공부하신 적이 있거나 쉽다고 느껴지시는 분들께서는 아래의 내용을 추가로 공부해 보시는 것을 추천해 드립니다.

- NestedScrollView
- FloatingActionButton
- FrameLayout

## 🎯 키워드 Essential

---

<aside>
💡 키워드를 명확히 알고 있어야 기억이 더 뚜렷해지는 것 같아요. 자유롭게 서칭하면서 공부하고 본인의 언어로 가공시키면 남들에게 설명하는 것이 쉬워질거에요~
***공식 문서 강추!***

</aside>

- 플랫폼
    
    다수가 참여할 수 있는 하나의 공간이며, 그 안에서 다양한 가치를 공유하며 새로운 가치를 창출하는 공간이다.
    응용 소프트웨어를 실행하기 위해 쓰이는 하드웨어와 소프트웨어의 결합으로, 
    소프트웨어를 실행할 수 있는 기반으로도 불린다.
    * 안드로이드 시스템 자체를 플랫폼이라고 부른다.
    
- Android OS
    - 정의: 리눅스 커널 버전을 비롯하여 오픈 소스 소프트웨어에 기반을 둔 모바일 운영체제이다.
    - 특징: 리눅스 커널 위에서 동작하고, 자바와 코틀린으로 앱을 만들어 동작
- Android의 Architecture
    - 안드로이드의 권장 아키텍쳐는 무엇일까요?
        - **MVVM** 또는 **MVI** 패턴을 사용 및 **Jetpack 라이브러리**를 통해 데이터 바인딩, UI 관리, 의존성 주입 등을 처리하는 것을 권장한다. 이러한 구조는 앱의 유지보수성과 확장성을 높이며 **모듈화된 레이어**를 통하여 관심사를 분리하고 복잡성을 관리하는 것이 중요하다.
            
            [Android 아키텍처 권장사항  |  Android Developers](https://developer.android.com/topic/architecture/recommendations?hl=ko)
            
    - 안드로이드 아키텍쳐 컴포넌트 (AAC)는 무엇일까요?
        - 테스트와 유지보수가 쉬운 앱을 디자인할 수 있도록 돕는 라이브러리의 모음이다.
        종류로는 Lifcycles, LiveData, ViewModel, Room, Paging, Databinding, Navigation, WorkManager 가 있다.
        
        ![](https://blog.kakaocdn.net/dn/bOEwPt/btsMObsZC4p/xDpji68pM1ovYa958kvFp1/img.png)
        
    
- Manifest의 주요 속성
    
    Manifest는 앱의 기본 정보와 시스템 권한, 컴포넌트 등을 정의하는 필수적인 설정 파일이다.
    앱이 실행될 때 안드로이드 운영체제는 이 파일을 참고하여 앱의 구조와 동작 방식을 이해하고, 필요한 권한과 기능을 적절히 할당한다.
    
    - 주요 속성 : <manifest>, <application>, <activity>, <service>, <receiver>, 
    <uses-permission>, <meta-data>
        
        
        | 태그 | 주요 속성 |
        | --- | --- |
        | `<manifest>` | `package`, `xmlns:android` |
        | `<application>` | `allowBackup`, `icon`, `label`, `theme`, `usesCleartextTraffic` |
        | `<activity>` | `name`, `exported`, `launchMode`, `screenOrientation`, `theme` |
        | `<service>` | `name`, `exported`, `foregroundServiceType` |
        | `<receiver>` | `name`, `enabled`, `exported` |
        | `<uses-permission>` | `name` (필요한 권한 설정) |
        | `<meta-data>` | `name`, `value` (앱 설정 값) |
    1. `<manifest>` 태그
        
        매니페스트 파일의 최상위 태그
        
        | 속성 | 설명 |
        | --- | --- |
        | `package` | 앱의 고유 패키지명을 정의(예:`.example.myapp`) |
        | `xmlns:android` | 안드로이드 네임스페이스를 정의 (`http://schemas.android.com/apk/res/android`) |
        
        ```xml
        <manifest xmlns:android="http://schemas.android.com/apk/res/android"
            package="com.example.myapp">
        
        ```
        
    2. `<application>` 태그
        
        앱의 전체적인 설정을 정의
        
        | 속성 | 설명 |
        | --- | --- |
        | `android:allowBackup` | 앱의 데이터 백업을 허용할지 여부 (`true`/`false`) |
        | `android:icon` | 앱 아이콘 지정 (`@mipmap/ic_launcher`) |
        | `android:label` | 앱 이름 지정 |
        | `android:theme` | 앱의 기본 테마 설정 |
        | `android:networkSecurityConfig` | 네트워크 보안 설정 파일 지정 |
        | `android:supportsRtl` | 오른쪽에서 왼쪽(RTL) 언어 지원 여부 |
        | `android:usesCleartextTraffic` | HTTP 비암호화 트래픽 허용 여부 (`true`/`false`) |
        
        ```xml
        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="MyApp"
            android:theme="@style/AppTheme"
            android:usesCleartextTraffic="false">
        
        ```
        
    3. `<activity>` 태그
        
        앱에서 사용되는 **액티비티(화면)** 를 정의
        
        | 속성 | 설명 |
        | --- | --- |
        | `android:name` | 액티비티 클래스명 지정 (예: `.MainActivity`) |
        | `android:exported` | 다른 앱에서 이 액티비티를 호출할 수 있는지 여부 (`true`/`false`) |
        | `android:launchMode` | 액티비티 실행 방식 (`standard`, `singleTop`, `singleTask`, `singleInstance`) |
        | `android:theme` | 특정 액티비티에 사용할 테마 지정 |
        | `android:screenOrientation` | 화면 방향 지정 (`portrait`, `landscape`) |
        | `android:windowSoftInputMode` | 키보드와 화면 UI의 동작 방식 지정 |
        
        ```xml
        <activity android:name=".MainActivity"
            android:exported="true"
            android:launchMode="singleTask"
            android:screenOrientation="portrait">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>
                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
        
        ```
        
    4. `<service>` 태그
        
        백그라운드에서 실행되는 **서비스(Service)** 를 정의
        
        | 속성 | 설명 |
        | --- | --- |
        | `android:name` | 서비스 클래스명 지정 |
        | `android:exported` | 다른 앱에서 이 서비스를 사용할 수 있는지 여부 |
        | `android:foregroundServiceType` | 포그라운드 서비스 유형 (예: `mediaPlayback`, `location`) |
        
        ```xml
        <service android:name=".MyService"
            android:exported="false"
            android:foregroundServiceType="location"/>
        
        ```
        
    5. `<receiver>` 태그
        
        **브로드캐스트 리시버(Broadcast Receiver)** 를 정의
        
        | 속성 | 설명 |
        | --- | --- |
        | `android:name` | 리시버 클래스명 지정 |
        | `android:enabled` | 리시버 활성화 여부 (`true`/`false`) |
        | `android:exported` | 다른 앱에서 사용할 수 있는지 여부 |
        
        ```xml
        <receiver android:name=".MyReceiver"
            android:enabled="true"
            android:exported="false"/>
        
        ```
        
    6. `<uses-permission>` 태그
        
        앱에서 필요한 **권한을 요청**할 때 사용
        
        | 속성 | 설명 |
        | --- | --- |
        | `android:name` | 요청할 권한의 이름 (예: `android.permission.INTERNET`) |
        
        ```xml
        <uses-permission android:name="android.permission.INTERNET"/>
        <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
        
        ```
        
    7. `<meta-data>` 태그
        
        추가적인 **앱 설정 값**을 정의할 때 사용
        
        | 속성 | 설명 |
        | --- | --- |
        | `android:name` | 메타데이터 키 이름 |
        | `android:value` | 설정할 값 |
        
        ```xml
        <meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="YOUR_API_KEY_HERE"/>
        
        ```
        
    
    ---
    
- Manifest의 4대 컴포넌트
    1. `Activity (액티비티)`
        - 화면을 구성하는 요소, UI 담당
        - 사용자가 앱과 상호작용할 수 있도록 화면 제공
        - 주요 속성
            - `android:name`: 액티비티 클래스명
            - `android:exported`: 외부 앱에서 접근 가능 여부
            - `android:launchMode`: 액티비티 실행 방식
            - `android:screenOrientation`: 화면 방향 설정
        
        ```xml
        <activity android:name=".MainActivity"
            android:exported="true"
            android:launchMode="singleTask"
            android:screenOrientation="portrait">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>
                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
        ```
        
    2. `Service (서비스)`
        - UI 없이 백그라운드에서 실행되는 컴포넌트
        - 주요 속성
            - `android:name`: 서비스 클래스명
            - `android:exported`: 다른 앱에서 이 서비스를 사용할 수 있는지 여부
            - `android:foregroundServiceType`: 포그라운드 서비스 유형 지정 (예: `mediaPlayback`, `location`)
            - * enabled를 사용하여 서비스를 사용할 수 있는지를 설정함
        
        ```xml
        <service android:name=".MyService"
            android:exported="false"
            android:foregroundServiceType="location"/>
        ```
        
    3. `Broadcast Receiver (브로드캐스트 리시버)`
        - 시스템 또는 다른 앱에서 발생하는 이벤트를 감지하고 처리하는 역할
        - 주요 속성
            - `android:name`: 리시버 클래스명
            - `android:enabled`: 리시버 활성화 여부 (`true`/`false`)
            - `android:exported`: 다른 앱에서 사용할 수 있는지 여부
        
        ```xml
        <receiver android:name=".MyReceiver"
            android:enabled="true"
            android:exported="false">
            <intent-filter>
                <action android:name="android.intent.action.BOOT_COMPLETED"/>
            </intent-filter>
        </receiver>
        ```
        
    4. `Content Provider (콘텐츠 프로바이더)`
        - 앱 간 데이터 공유를 가능하게 해주는 컴포넌트
        - 주요 속성
            - `android:name`: 콘텐츠 프로바이더 클래스명
            - `android:authorities`: 프로바이더(콘텐츠 제공자)의 고유 식별자
            - `android:exported`: 다른 앱에서 접근 가능 여부
- Intent
    - Intent의 역할은 무엇일까요?
    작업을 요청하는 데 사용할 수 있는 메시지 객체이다. 구성요소 간의 통신을 촉진하는 데에 사용된다.
    
    [인텐트 및 인텐트 필터  |  Android Developers](https://developer.android.com/guide/components/intents-filters?hl=ko)
    
    - 명시적 Intent와 암시적 Intent의 차이는 무엇일까요?
        - 명시적 Intent
        전체 `ComponentName`을 지정하여 인텐트를 충족하는 애플리케이션의 구성요소를 저장한다.
        - 암시적 Intent
        특정 구성요소의 이름을 저장하지 않고, 그 대신 수행할 일반적인 작업을 선언하여 다른 앱의 구성요소가 이를 처리할 수 있도록 한다.
        
        ![image.png](Chapter%201%20Platform%20&%20Layout%201b6b57f4596b8087b7fac0dee941f5bb/image.png)
        
- Android Layout
    1. TextView
    안드로이드 UI를 구성함에 있어서 화면에 텍스트를 표시하는 기능을 담당하며, 안드로이드에서 제공하는 위젯 중 가장 많이 사용되는 위젯이다.
    스타일, 크기, 색상 등을 변경할 수 있다.
        
        ```xml
        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Hello, World!"
            android:textSize="16sp"
            android:textColor="@android:color/black"/>
        ```
        
    2. Button
    TextView가 Button의 부모 위젯이다. 이름에서 알 수 있듯이 버튼이니까, 클릭이 가능하다.
    onClickListener를 통해 이벤트 처리가 가능하다.
        
        ```xml
        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Click Me"/>
        ```
        
        ```kotlin
        button.setOnClickListener {
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
        }
        ```
        
    3. ImageView
    이미지를 표시하는 위젯이다.
        
        ```xml
        <ImageView
            android:id="@+id/imageView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/sample_image"/>
        ```
        
    4. RecyclerView
    많은 양의 데이터를 효율적으로 ‘리스트’ 형태로 표시하는 위젯이다.
    Adapter, ViewHolder 패턴을 사용해야 한다.
    * 객체가 화면을 벗어나도 데이터가 없어지지 않는다.
        
        ```xml
        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/recyclerView"
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>
        ```
        
        ```kotlin
        class MyAdapter(private val items: List<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
            class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                val textView: TextView = itemView.findViewById(R.id.textView)
            }
        
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
                return ViewHolder(view)
            }
        
            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                holder.textView.text = items[position]
            }
        
            override fun getItemCount() = items.size
        }
        ```
        
    5. ScrollView
    콘텐츠가 화면을 넘어갈 경우 스크롤 가능하게 만드는 레이아웃(혹은 뷰 그룹)이다.
    ScrollView 내부에는 하나의 ViewGroup만 포함해야 한다.
    * 수직만 지원하는데, 수평을 원한다면 orientation을 선언해주어야 한다.
        
        ```xml
        <ScrollView
            android:layout_width="match_parent"
            android:layout_height="match_parent">
            
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical">
        
                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text="Scrollable Content"/>
        
            </LinearLayout>
        </ScrollView>
        ```
        
    6. NestedScrollView
    위에서 설명한 ScrollView의 확장 버전이다.
    RecyclerView와 같은 스크롤 가능한 뷰와 함께 사용할 때 유용하다.
    * RecyclerView와 함께 사용하는 것은 추천하지 않는다.
        
        ```xml
        <androidx.core.widget.NestedScrollView
            android:layout_width="match_parent"
            android:layout_height="match_parent">
        
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical">
        
                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text="Nested ScrollView Content"/>
        
            </LinearLayout>
        </androidx.core.widget.NestedScrollView>
        ```
        
    7. BottomNavigationView
    화면 하단에 고정된 네비게이션 바를 제공하는 UI 컴포넌트이다.
        
        ```xml
        <com.google.android.material.bottomnavigation.BottomNavigationView
            android:id="@+id/bottomNavigationView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom"
            app:menu="@menu/bottom_nav_menu"/>
        ```
        
        ```xml
        <!-- res/menu/bottom_nav_menu.xml -->
        <menu xmlns:android="http://schemas.android.com/apk/res/android">
            <item android:id="@+id/home"
                android:title="Home"
                android:icon="@drawable/ic_home"/>
            <item android:id="@+id/profile"
                android:title="Profile"
                android:icon="@drawable/ic_profile"/>
        </menu>
        ```
        
    8. TabLayout
    여러 개의 탭을 제공하는 UI 컴포넌트이다.
        
        ```xml
        <com.google.android.material.tabs.TabLayout
            android:id="@+id/tabLayout"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"/>
        ```
        
        ```kotlin
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"))
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"))
        ```
        
    9. FloatingActionButton
    둥근 모양의 버튼으로 액션을 강조할 때 사용된다.
        
        ```xml
        <com.google.android.material.floatingactionbutton.FloatingActionButton
            android:id="@+id/fab"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/ic_add"
            app:layout_anchor="@id/recyclerView"
            app:layout_anchorGravity="bottom|end"/>
        ```
        
    10. margin
    뷰의 외부 여백을 설정하는 속성이다.
        
        ```xml
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Hello"
            android:layout_margin="16dp"/>
        ```
        
    11. padding
    뷰의 내부 여백을 설정하는 속성이다.
        
        ```xml
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Hello"
            android:padding="16dp"/>
        ```
        
    12. chainStyle
    ConstraintLayout 에서 뷰들을 하나의 체인으로 묶어 정렬하는 속성이다.
    * 양방향의 위치를 조정해서 묶는 것.
    * 위쪽과 아래쪽을 조정하는 것을 말함.
        
        ```xml
        <androidx.constraintlayout.widget.ConstraintLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent">
        
            <TextView
                android:id="@+id/text1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Item 1"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintEnd_toStartOf="@id/text2"/>
        
            <TextView
                android:id="@+id/text2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Item 2"
                app:layout_constraintStart_toEndOf="@id/text1"
                app:layout_constraintEnd_toEndOf="parent"/>
        
            <androidx.constraintlayout.widget.ConstraintSet>
                <Constraint
                    app:layout_constraintHorizontal_chainStyle="packed"/>
            </androidx.constraintlayout.widget.ConstraintSet>
        
        </androidx.constraintlayout.widget.ConstraintLayout>
        ```
        
    13. id 네이밍
    뷰의 ID를 설정할 때 일관된 네이밍 규칙을 따르는 것이 중요하다.
    일반적인 네이밍 규칙은 아래와 같다.
        - `tv_` → `TextView`
        - `btn_` → `Button`
        - `img_` → `ImageView`
        - `rv_` → `RecyclerView`
        - `fab_` → `FloatingActionButton`
        
        ```xml
        <TextView
            android:id="@+id/tv_title"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Title"/>
        ```
        

## 🕐 1주차 Essential

---

### 안드로이드 개발 방식

여러분들께서 Android Studio를 설치하고 기본 프로젝트를 생성하면 다음과 같이 compose로 이루어져있는 코드가 보이실겁니다. Android의 기본 틀을 이해를 돕기 위한 코드이므로 compose 코드는 대략적인 느낌만 보시면 됩니다.

```kotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContent {
           GreetingCardTheme {
               // A surface container that uses the 'background' color from the theme
               Surface(color = MaterialTheme.colors.background) {
                   Greeting("Android")
               }
           }
       }
   }
}

@Composable
fun Greeting(name: String) {
   Surface(color = Color.Magenta) {
       Text(text = "Hi, my name is $name!", modifier = Modifier.padding(24.dp))
   }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   GreetingCardTheme {
       Greeting("Meghan")
   }
}
```

`Composable Annotation(@)`이 사용된 함수들에서 화면에 표시할 텍스트를 설정하고 
`MainActivity class`에서는 화면의 레이아웃 형태를 지정하는 것으로 보입니다.

반면, XML 기반에 대해서 봅시다.

```kotlin
package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        
        setContentView(binding.root)
    }
}
```

```kotlin
package com.example.myapplication

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val name: String = "Android"
}
```

여기까지 보시면 compose처럼 Kotlin으로 작성이 되어있습니다. 
다만, 그 어디에도 화면의 레이아웃을 지정하는 코드가 보이지 않는 것 같습니다.

이제 XML 코드를 살펴봅시다.

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <data>
        <variable
            name="viewModel"
            type="com.example.myapplication.MainViewModel" />
    </data>

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <TextView
            android:id="@+id/greetingTextView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:padding="24dp"
            android:text="@{`Hi, my name is ` + viewModel.name}"
            android:textColor="@android:color/white"
            android:background="@android:color/holo_purple"/>
    </RelativeLayout>
</layout>
```

형태가 마치 html처럼 각 레이아웃의 특성에 맞도록 태그로 감싸져있는 모습을 볼 수 있습니다.
또한, viewmodel이라는 것을 통해서 화면에 표시되는 데이터가 연결되어있는 것 또한 유추해볼 수 있습니다.

이처럼 화면의 뼈대는 XML이 담당하고 뼈대에 살이 붙여지는 즉 다시 말해서 실제 데이터를 관리하는 곳은 viewmodel이고 activity가 지반을 이루고 있다고 볼 수 있습니다.

자, 그렇다면 XML이라고 하는 것은 과연 뭐길래 이러한 특수성을 가지는 것일까요?

`XML(eXtensible Markup Language)`라고 해서 HTML의 마크업 랭귀지라는 단어를 공유하고 있는 것으로 보아 비슷한 역할을 하신다고 추측하실텐데 그것이 맞습니다. 웹에서도 HTML이 뼈대를 이룬다고 보통 알고 있는데 안드로이드에서도 비슷한 역할을 한다고 보시면 됩니다.

앞으로도 이렇게 Kotlin 클래스와 XML 레이아웃 양쪽을 번갈아가면서 코딩을 하시게 될 것입니다.

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:versionCode="1"
    android:versionName="1.0">

    <uses-sdk android:minSdkVersion="26" android:targetSdkVersion="34" />

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">

        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
```

모든 안드로이드 프로젝트에는 반드시 패키지 이름, 진입점, 구성 요소, 권한 및 메타데이터와 같은 앱 대한 필수 정보를 정의하는 `AndroidManifest.xml` 파일이 있어야 합니다.

패키지 정보는 안드로이드 시스템 (물리적 디바이스)와 Google Play에서 본인의 앱이라는 것을 증명할 수 있는 유일한 방법입니다. 안드로이드 빌드 툴은 패키지 정보를 다음과 같이 사용합니다.

[애플리케이션 기본 항목  |  Android Developers](https://developer.android.com/guide/components/fundamentals?hl=ko)

[앱 매니페스트 개요  |  Android Developers](https://developer.android.com/guide/topics/manifest/manifest-intro?hl=ko)

![image.png](Chapter%201%20Platform%20&%20Layout%201b6b57f4596b8087b7fac0dee941f5bb/image%201.png)

새 프로젝트를 생성하면 이와 같이 SDK 버전을 선택할 수 있는 화면이 나오게 됩니다.

최소 SDK를 선택하면 최소 버전부터 그 위의 버전까지 다 커버가 가능해집니다.

또한, 나중에 프로젝트를 생성하고 나면 `minsdk`뿐만 아니라 `targetsdk`도 설정이 되는데요

안드로이드 스튜디오 버전이 올라갈 때마다 추천해주는 minsdk 버전도 올라가는 것을 통해 그 아래의 버전들은 더 이상 지원해주지 않는 것을 알 수 있습니다.

하여 플레이스토어에 앱을 런칭할 때도 `targetsdk`를 잘못 지정하면 심사에서도 불합격이 뜬다고 합니다.

### SVG 이미지로  Vector asset 사용하기

---

보통 png나 jpg 파일 형식으로 이미지를 첨부하지만 그렇게 할 경우 용량이 너무 크기에 svg 형태로 이미지를 넣어야합니다.

`drawble` 폴더에서 `Vector Asset`을 선택합니다.

![image.png](Chapter%201%20Platform%20&%20Layout%201b6b57f4596b8087b7fac0dee941f5bb/image%202.png)

클립 아트를 써도 되고 Figma에 있는 이미지로 할 경우 `Local file`에서 경로를 선택해서 첨부하면 이미지가 xml 파일 형식으로 저장이 될 것입니다. 

![image.png](Chapter%201%20Platform%20&%20Layout%201b6b57f4596b8087b7fac0dee941f5bb/image%203.png)

### 구글 권장사항: Constraint Layout

`Constraint Layout`은 구글이 권장하는 레이아웃이고 프로젝트를 처음 생성할 때도 기본적으로 설정되어있는 레이아웃입니다.

키워드를 학습하셨다면 `Relative Layout`과 `Linear Layout`을 숙지하고 계실텐데요 `Constraint Layout`은 쉽게 말해 그 둘의 조합이라고 생각하시면 편합니다.

여기서는 일종의 연결선(chain) 개념이 들어가서 한 레이아웃 안의 여러가지 `view`들 간에 그룹화를 통해 유연하게 대처할 수 있다는 장점이 있어 기기별로 다른 해상도를 커버할 수 있게 됩니다.

[ConstraintLayout으로 반응형 UI 빌드  |  Views  |  Android Developers](https://developer.android.com/develop/ui/views/layout/constraint-layout?hl=ko)

![image.png](Chapter%201%20Platform%20&%20Layout%201b6b57f4596b8087b7fac0dee941f5bb/image%204.png)

XML에서 코드를 직접 작성할 수 있지만 `Layout Editor`를 통해서 코드를 직접 작성하지 않고도 레이아웃을 구성할 수 있습니다.

[뷰로 UI 개발  |  Android Studio  |  Android Developers](https://developer.android.com/studio/write/layout-editor?hl=ko)

## 🔥 미션

---

## ✅ 1주차 실전미션

---

<aside>
💡 실전미션을 통해 Demoday를 대비해보자!

- [x]  Figma에 있는 단일 화면을 구성해보기
- [x]  `LinearLayout`, `ConstraintLayout`등 본인이 적절하다고 판단되는 것으로 화면을 구현하고나서 어떤 Layout이 더 효율적인지 정리해보기
- [x]  감정우표 옵션을 클릭했을 때 임의의 다음 화면으로 넘어갈 수 있도록 설정해보기
- 글씨체 종류는 상관없습니다!

[https://www.figma.com/design/lorwJybwtNvn1FuOy0gW97/UMC-7th-Android-1st-Mission?m=auto&t=vdO3OlB5nb83iCST-6](https://www.figma.com/design/lorwJybwtNvn1FuOy0gW97/UMC-7th-Android-1st-Mission?m=auto&t=vdO3OlB5nb83iCST-6)

</aside>

## 📋 1주차 개발일지

---

<aside>
💡 미션 수행하신 내용을 아래에 정리해주세요!

</aside>

AndroidManifest.xml 파일 내부 값 수정

```xml
tools:targetApi="31"
```

build.gradle.kts(:app) 파일 내부 값 수정

```xml
compileSdk = 35
minSdk = 25
targetSdk = 34
```

- MainActivity.kt
    
    ```kotlin
    package com.example.test
    
    import android.content.Intent
    import android.os.Bundle
    import android.widget.ImageView
    import androidx.appcompat.app.AppCompatActivity
    
    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            //enableEdgeToEdge()
            setContentView(R.layout.activity_main)
    
            val layout1 = this.findViewById<ImageView>(R.id.emoji1)
            layout1.setOnClickListener{
                val intent = Intent(this,Emoji1::class.java)
                startActivity(intent)
            }
    
            val layout2 = this.findViewById<ImageView>(R.id.emoji2)
            layout2.setOnClickListener{
                val intent2 = Intent(this,Emoji2::class.java)
                startActivity(intent2)
            }
    
            val layout3 = this.findViewById<ImageView>(R.id.emoji3)
            layout3.setOnClickListener {
                val intent3 = Intent(this,Emoji3::class.java)
                startActivity(intent3)
            }
    
            val layout4 = this.findViewById<ImageView>(R.id.emoji4)
            layout4.setOnClickListener {
                val intent4 = Intent(this,Emoji4::class.java)
                startActivity(intent4)
            }
    
            val layout5 = this.findViewById<ImageView>(R.id.emoji5)
            layout5.setOnClickListener {
                val intent5 = Intent(this,Emoji5::class.java)
                startActivity(intent5)
            }
        }
    }
    ```
    
- activity_main.xml
    
    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/main"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">
    
        <TextView
            android:id="@+id/today"
            android:fontFamily="@font/font1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="오늘 하루는 어땠나요?"
            android:textSize="30sp"
            android:layout_marginTop="90dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
    
        <TextView
            android:id="@+id/select"
            android:fontFamily="@font/font1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="감정 우표를 선택주세요"
            android:textSize="20sp"
            android:layout_marginTop="5dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/today" />
    
        <TextView
            android:id="@+id/explain"
            android:fontFamily="@font/font1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="18sp"
            android:text="선택한 감정우표를 기반으로 맞춤형 질문이 배달됩니다"
            android:layout_marginTop="20dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/select" />
    
        <LinearLayout
            android:id="@+id/layout1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:layout_marginTop="30dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/explain">
    
            <ImageView
                android:id="@+id/emoji1"
                android:layout_width="40dp"
                android:layout_height="43dp"
                android:layout_gravity="center"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/explain"
                app:srcCompat="@drawable/emoji1" />
    
            <TextView
                android:id="@+id/text1"
                android:fontFamily="@font/font1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="13sp"
                android:layout_marginTop="10dp"
                android:text="더없이 행복한 하루였어요" />
    
        </LinearLayout>
    
        <LinearLayout
            android:id="@+id/layout2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:layout_marginTop="30dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/layout1">
    
            <ImageView
                android:id="@+id/emoji2"
                android:layout_width="40dp"
                android:layout_height="43dp"
                android:layout_gravity="center"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/explain"
                app:srcCompat="@drawable/emoji2" />
    
            <TextView
                android:id="@+id/text2"
                android:fontFamily="@font/font1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="13sp"
                android:layout_marginTop="10dp"
                android:text="들뜨고 흥분돼요" />
    
        </LinearLayout>
    
        <LinearLayout
            android:id="@+id/layout3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:layout_marginTop="30dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/layout2">
    
            <ImageView
                android:id="@+id/emoji3"
                android:layout_width="40dp"
                android:layout_height="43dp"
                android:layout_gravity="center"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/explain"
                app:srcCompat="@drawable/emoji3" />
    
            <TextView
                android:id="@+id/text3"
                android:fontFamily="@font/font1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="13sp"
                android:layout_marginTop="10dp"
                android:text="평범한 하루였어요" />
    
        </LinearLayout>
    
        <LinearLayout
            android:id="@+id/layout4"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:layout_marginTop="30dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/layout3">
    
            <ImageView
                android:id="@+id/emoji4"
                android:layout_width="40dp"
                android:layout_height="43dp"
                android:layout_gravity="center"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/explain"
                app:srcCompat="@drawable/emoji4" />
    
            <TextView
                android:id="@+id/text4"
                android:fontFamily="@font/font1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="13sp"
                android:layout_marginTop="10dp"
                android:text="생각이 많아지고 불안해요" />
    
        </LinearLayout>
    
        <LinearLayout
            android:id="@+id/layout5"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:layout_marginTop="30dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/layout4">
    
            <ImageView
                android:id="@+id/emoji5"
                android:layout_width="40dp"
                android:layout_height="43dp"
                android:layout_gravity="center"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/explain"
                app:srcCompat="@drawable/emoji5" />
    
            <TextView
                android:id="@+id/text5"
                android:fontFamily="@font/font1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="13sp"
                android:layout_marginTop="10dp"
                android:text="부글부글 화가 나요" />
    
        </LinearLayout>
    
    </androidx.constraintlayout.widget.ConstraintLayout>
    ```
    

![Screenshot_1742291064.png](Chapter%201%20Platform%20&%20Layout%201b6b57f4596b8087b7fac0dee941f5bb/Screenshot_1742291064.png)

![Screenshot_1742291080.png](Chapter%201%20Platform%20&%20Layout%201b6b57f4596b8087b7fac0dee941f5bb/Screenshot_1742291080.png)

![Screenshot_1742291067.png](Chapter%201%20Platform%20&%20Layout%201b6b57f4596b8087b7fac0dee941f5bb/Screenshot_1742291067.png)

![Screenshot_1742291083.png](Chapter%201%20Platform%20&%20Layout%201b6b57f4596b8087b7fac0dee941f5bb/Screenshot_1742291083.png)

![Screenshot_1742291072.png](Chapter%201%20Platform%20&%20Layout%201b6b57f4596b8087b7fac0dee941f5bb/Screenshot_1742291072.png)

![Screenshot_1742291088.png](Chapter%201%20Platform%20&%20Layout%201b6b57f4596b8087b7fac0dee941f5bb/Screenshot_1742291088.png)

## ⚡ 트러블 슈팅

---

<aside>
💡 실습하면서 생긴 문제들에 대해서, **이슈 - 문제 - 해결** 순서로 작성해주세요.

</aside>

<aside>
💡 스스로 해결하기 어렵다면? 스터디원들에게 도움을 요청하거나 **너디너리의 지식IN 채널에 질문**해보세요!

</aside>

- ⚡이슈 No.1 (예시, 서식만 복사하시고 지워주세요.)
    
    **`이슈`**
    
    👉 앱 실행 중에 노래 다음 버튼을 누르니까 앱이 종료되었다.
    
    **`문제`**
    
    👉 노래클래스의 데이터리스트의 Size를 넘어서 NullPointException이 발생하여 앱이 종료된 것이었다. 
    
    **`해결`**
    
    👉  노래 다음 버튼을 눌렀을 때 데이터리스트의 Size를 검사해 Size보다 넘어가려고 하면 다음으로 넘어가는 메서드를 실행시키지 않고, 첫 노래로 돌아가게끔 해결
    
    **`참고레퍼런스`**
    
    [안드로이드 스튜디오 Render problem 해결방법 (레이아웃 XML 렌더링 에러, 문제, 오류)](https://wishml.tistory.com/53)
    

---

Copyright © 2025 Daemon(정승원) All rights reserved.