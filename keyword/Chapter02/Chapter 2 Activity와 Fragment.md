# Chapter 2. Activity와 Fragment

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

- Activity와 Fragment가 무엇인지 이해하고 사용할 수 있다.
- ViewBinding이 무엇인지 이해하고 사용할 수 있다.
- Intent를 사용하여 새로운 Activity를 띄울 수 있다.
- Activity - Activity 간 통신을 할 수 있다.
- Activity - Fragment 간 통신을 할 수 있다.
- 하나의 Activity 안에서 여러 Fragment를 다룰 수 있다.

## ⚠️ 스터디 진행 방법

---

1. 스터디를 진행하기 전, 워크북 내용들을 모두 채우고 서로 모르는 내용들을 공유해주세요.
2. 미션을 모두 진행하시고 파트장 분께서 스터디원들의 코드 리뷰를 진행해주세요.
3. 다음주 스터디를 진행하기 전, 파트장의 간략한 설명을 듣고 개념의 윤곽을 잡아보세요.

## ✨ 파트장이 남기는 말

---

이번 주차에서는 Activity와 Fragment, 화면 전환, 데이터 전달에 대해 공부합니다. Activity와 Fragment는 여러분이 안드로이드 개발을 할 때 빠질 수 없는 부분인 만큼 잘 정리해 두시면 좋을 것 같습니다. 참고 자료에도 여러분들이 읽어보면 좋을 것 같은 자료들을 넣어 놓았으니 확인해 보세요!!

한 번 공부하신 적이 있거나 쉽다고 느껴지시는 분들께서는 아래의 내용을 추가로 공부해 보시는 것을 추천해 드립니다.

- 암시적 Intent
- Activity Stack
- Fragment BackStack
- Fragment Result API

## 🎯 키워드 Essential

---

<aside>
💡 키워드를 명확히 알고 있어야 기억이 더 뚜렷해지는 것 같아요. 자유롭게 서칭하면서 공부하고 본인의 언어로 가공시키면 남들에게 설명하는 것이 쉬워질거에요~
***공식 문서 강추!***

</aside>

- Activity
    - Activity란 무엇인가요?
    [`Activity`](https://developer.android.com/reference/android/app/Activity?hl=ko) 클래스는 Android의 중요한 구성요소 활동이 시작되고 결합되는 방식은 플랫폼 애플리케이션 모델의 일부이다. 기존의 프로그래밍 패러다임과 달리 `main()` 메서드로 실행되는 앱인 경우 Android 시스템은 다음과 같은 방법으로 [`Activity`](https://developer.android.com/reference/android/app/Activity?hl=ko) 인스턴스의 코드를 시작한다. 호출의 특정 단계에 해당하는 특정 콜백 메서드를 수명 주기를 지원한다.
    - 새로운 Activity를 만들기 위해선 어떻게 해야 할까요?
    크게 3단계로 나눌 수 있다.
    1. Activity 클래스 상속
        
        `android.app.Activity` 또는 `androidx.appcompat.app.AppCompatActivity` 를 상속받아 새로운 Activity 생성
        
        ```kotlin
        class MainActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main) // UI 레이아웃 설정
            }
        }
        ```
        
    2. AndroidManifest.xml에 등록
        
        `AndroidManifest.xml` 파일에 새로운 Activity를 `<activity>` 태그로 등록
        
        ```xml
        <activity android:name=".MainActivity"></activity>
        ```
        
    3. Intent를 사용하여 Activity 실행
        
        다른 Activity에서 새로운 Activity를 시작하기 위하여 `Intent` 사용
        
        ```kotlin
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        ```
        
    - AppcompatActivity란 무엇인가요?
        
        `AppCompatActivity`는 `androidx.appcompat.app` 패키지에 포함된 클래스이다. 안드로이드에서 최신 UI 기능을 사용할 수 있도록 지원하는 Activity의 기본 클래스이다. 백워드 호환성(Backward Compatibillity)을 제공하고 구버전(Android 4.x 이상)에서도 최신 기능을 사용할 수 있도록 한다.
        
        특징
        
        - ActionBar 지원
            - `AppCompatActivity`를 사용하여 `Toolbar`를 포함한 `ActionBar`를 쉽게 활용
        - 테마 및 스타일 호환성 제공
            - `Material Components` 및 최신 UI 요소를 구버전에서도 사용할 수 있도록 지원
        - Activity 라이프사이클 관리
            - 기본 `Activity` 클래스의 기능을 확장하여 더 나은 상태 저장 및 복원을 지원
        
        사용 예제
        
        ```kotlin
        import androidx.appcompat.app.AppCompatActivity
        import android.os.Bundle
        
        class MainActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
            }
        }
        ```
        
    
    https://developer.android.com/guide/components/activities/intro-activities?hl=ko
    
    https://developer.android.com/reference/androidx/appcompat/app/AppCompatActivity
    
- Activity-Layout 결합
    - findViewById
        - findViewById 사용법
            - `findViewById`는 XML에 정의된 View를 `Activity` 또는 `Fragment`에서 참조하는 기존 방식이다.
            
            ```kotlin
            val textView: TextView = findViewById(R.id.textView)
            textView.text = "Hello, World!"
            ```
            
    - ViewBinding
        - ViewBinding 사용법
            - `ViewBinding`은 컴파일 시 XML 파일과 연결되는 클래스를 자동으로 생성하여, `findViewById` 없이 안전하게 View에 접근할 수 있도록 해준다.
            - 설정 방법
                
                build.gradle(:app)에서 ViewBinding 활성화
                
                ```xml
                android {
                    buildFeatures {
                        viewBinding = true
                    }
                }
                ```
                
                ```kotlin
                class MainActivity : AppCompatActivity() {
                    private lateinit var binding: ActivityMainBinding
                
                    override fun onCreate(savedInstanceState: Bundle?) {
                        super.onCreate(savedInstanceState)
                        binding = ActivityMainBinding.inflate(layoutInflater)
                        setContentView(binding.root)
                
                        binding.textView.text = "Hello, ViewBinding!"
                    }
                }
                
                ```
                
    - findViewById보다 ViewBinding이 권장되는 이유
        - findViewById의 단점
            - 타입 캐스팅 필요 → `findViewById<TextView>(R.id.textView)`처럼 사용해야 한다.
            - 잘못된 ID 사용 시 런타임 오류 발생 가능
            - 코드의 길이가 길어지고 가독성이 떨어짐
        - ViewBinding의 장점
            - 안전성 → Null Pointer Exception 방지 (findViewById에서 ID를 잘못 사용해도 오류 발생X)
            - 타입 안정성 → 자동 생성된 클래스로 TextView를 Button으로 잘못 캐스팅하는 실수 방지
            - 가독성 향상 → 간결한 코드로 UI 요소 접근 가능
            - 성능 향상 → findViewById보다 더 빠르게 View 참조 가능
    
    https://developer.android.com/reference/android/app/Activity#findViewById(int)
    
    https://developer.android.com/topic/libraries/view-binding?hl=ko
    
- 새로운 Activity를 띄우는 방법
    - Intent란 무엇일까요?
        
        안드로이드에서 컴포넌트 간의 통신을 담당하는 메시징 객체이며,
        특정 Activity 또는 Service를 지정하여 실행하는 `명시적 인텐트`와 실행할 작업을 지정하고, 이를 처리할 수 있는 앱을 android 시스템이 찾도록 요청하는 `암시적 인텐트`가 있다.
        
    - Intent를 사용하여 Activity 간 데이터를 전달하려면 어떻게 해야할까요?
        
        MainActivity → SecondActivity 로 데이터를 전달하는 방법
        `putExtra()` 메서드를 사용하여 전달한다.
        
        ```kotlin
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("message", "Hello, SecondActivity!")
        startActivity(intent)
        ```
        
        데이터를 받기 위해서는 `getStringExtra()` 또는 `getIntExtra()` 를 사용하여 데이터를 받는다.
        
        ```kotlin
        class SecondActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_second)
        
                val message = intent.getStringExtra("message") // 데이터 받기
                findViewById<TextView>(R.id.textView).text = message
            }
        }
        ```
        
        https://developer.android.com/reference/android/content/Intent
        
- 명시적 Intent와 암시적 Intent
    - 명시적 Intent란 무엇일까요?
        - 명시적 Intent는 대상 컴포넌트(Activity, Service 등)를 지정하여 실행하는 Intent이다.
        - 주로 같은 앱이나 특정 `Activity`나 `Service`를 실행할 때 사용한다.
    - 암시적 Intent란 무엇일까요?
        - 암시적 Intent는 명시적으로 대상 컴포넌트를 지정하지 않고, 특정 동작을 처리할 수 있는 앱을 시스템이 찾아서 실행하는 Intent이다.
    - 두 Intent를 사용하는 예시에는 각각 무엇이 있을까요?
    - 명시적 Intent
        - MainActivity → SecondActivity 간의 이동
            
            ```kotlin
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            ```
            
    - 암시적 Intent
        - 웹 브라우저에서 특정 url 열기
            
            ```kotlin
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.android.com"))
            startActivity(intent)
            ```
            
- Fragment
    - Framgent의 정의는 무엇일까요?
        - Activity 내에서 UI의 일부로 작동하는 독립적인 구성요소이다.
        - 하나의 Activity 안에서 여러 Fragment를 조합하여 UI를 구성할 수 있다.
        - Fragment는 수명 주기가 Activity와 연결되어 있으며 재사용이 가능하다.
    - Fragment를 사용하는 이유는 무엇일까요?
        - 유연한 UI 구성 → 화면 크기에 따라 다르게 배치 가능하다.
        - 코드 재사용성 증가 → 여러 Activity에서 동일한 Fragment 활용 가능
        - 백스택 관리 → Fragment 간 전환 시 백스택을 활용하여 뒤로 가기 지원
    - 새 Fragment는 어떻게 만들 수 있을까요?
        - Fragment 클래스를 상속받아서 구현해야 한다.
            
            ```kotlin
            class MyFragment : Fragment(R.layout.fragment_my) {
                override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                    super.onViewCreated(view, savedInstanceState)
                    // UI 초기화 및 이벤트 처리
                }
            }
            ```
            
    - Fragment는 어떻게 화면에 보이게 할 수 있을까요?
    - XML에서 추가
        
        ```xml
        <fragment
            android:name="com.example.MyFragment"
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>
        ```
        
    - 코드에서 동적으로 추가
        
        ```kotlin
        class MainActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
        
                val fragment = MyFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit()
            }
        }
        ```
        
        https://developer.android.com/guide/fragments?hl=ko
        
        https://developer.android.com/reference/androidx/fragment/app/FragmentManager
        
- Bundle
    - Bundle은 무엇일까요?
        - Bundle은 키-값 쌍으로 데이터를 저장하고 전달하는 객체이다.
        - 주로 `Activity`, `Fragment`, `Intent` 간 데이터 전달에 사용된다.
        - `putXXX()` 메서드로 데이터를 저장하고, `getXXX()` 메서드로 데이터를 가져온다.
    - Intent와 Bundle을 결합하는 방법은 무엇일까요?
    1. Intent에 Bundle을 추가한다.
        
        ```kotlin
        val bundle = Bundle()
        bundle.putString("username", "binaryroot")
        bundle.putInt("age", 25)
        
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtras(bundle) // Bundle을 Intent에 추가
        startActivity(intent)
        ```
        
    2. 다른 Activity에서 Bundle 데이터 받기
        
        ```kotlin
        class SecondActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_second)
        
                val bundle = intent.extras
                val username = bundle?.getString("username")
                val age = bundle?.getInt("age")
        
                Toast.makeText(this, "User: $username, Age: $age", Toast.LENGTH_SHORT).show()
            }
        }
        ```
        
        https://developer.android.com/reference/android/os/Bundle
        
        https://developer.android.com/guide/components/intents-filters?hl=ko
        
- FragmentManager
    - FragmentManager란 무엇일까요?
        - FragmentManager는 Fragment를 관리하고 조작하는 역할을 하는 클래스이다.
    - FragmentManager는 언제 사용해야 될까요?
    1. 동적으로 Fragment를 교체해야할 때
    2. Fragment 백스택 관리가 필요할 때
    3. Fragment 찾기 및 상태 확인이 필요할 때
    - `replace()`, `add()`, `remove()` 메서드를 사용하여 Fragment를 변경할 때 필요
        
        ```kotlin
        val fragment = MyFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
        ```
        
    - `addToBackStack(null)`을 사용하면 이전 Fragment 상태를 저장하고 뒤로 가기 가능
        
        ```kotlin
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MyFragment())
            .addToBackStack(null) // 뒤로 가기 지원
            .commit()
        ```
        
    - `findFragmentById()` 또는 `findFragmentByTag()` 를 사용하여 특정 Fragment 찾기 가능
        
        ```kotlin
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        ```
        
    
    https://developer.android.com/reference/androidx/fragment/app/FragmentManager
    
    https://developer.android.com/guide/fragments/fragmentmanager?hl=ko
    
- BottomNavigationView의 구성 요소
    - BottomNavigationView를 사용하려면 레이아웃에 추가를 해야합니다. 이 때 어떤 값들이 필수적으로 지정되어야 할까요?
        - `android:layout_width="match_parent"` → 가로 전체 사용
        - `android:layout_height="wrap_content"` → 내용 크기에 맞춤
        - `app:menu="@menu/bottom_nav_menu"` → 메뉴 리소스 지정
        
        ```xml
        <com.google.android.material.bottomnavigation.BottomNavigationView
            android:id="@+id/bottom_navigation"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom"
            app:menu="@menu/bottom_nav_menu" />
        ```
        
    - Menu 리소스 XML
        - <menu> 태그는 무엇일까요?
            - 네비게이션 메뉴 항목을 정의하는 컨테이너 역할을 한다.
            
            ```xml
            <menu xmlns:android="http://schemas.android.com/apk/res/android">
                <item
                    android:id="@+id/home"
                    android:icon="@drawable/ic_home"
                    android:title="Home"/>
                
                <item
                    android:id="@+id/profile"
                    android:icon="@drawable/ic_profile"
                    android:title="Profile"/>
            </menu>
            ```
            
        - <item> 태그는 무엇일까요?
            - 각각의 네비게이션 항목(버튼)을 정의하는 요소이다.
        - <item> 태그에 설정할 수 있는 항목에는 무엇이 있을까요?
            
            
            | 속성 | 설명 |
            | --- | --- |
            | `android:id`  | 고유한 ID (필수) |
            | `android:icon` | 아이콘 지정 (선택) |
            | `android:title` | 메뉴 항목의 텍스트 (필수) |
            | `android:enabled` | 활성화 여부 (true/false) |
            | `android:visible` | 보이기 여부 (true/false) |
            | `app:showAction` | 상단 앱 바에 표시할지 여부 |
    - 화면 구성
        
        ![Untitled](Chapter%202%20Activity%E1%84%8B%E1%85%AA%20Fragment%201beb57f4596b80e4be41dd98cc1368c9/Untitled.png)
        
        1. 왼쪽의 예시 화면에서 (A)와 (B)에 해당하는 각각의 알맞은 **화면 구성 요소**를 선택해주세요!
            - (A) = Activity
            - (B) = Fragment
        2. 왼쪽 화면을 구성하기 위해서 일반적으로 몇 개의 Fragment가 필요한가요??
            - 정답 ) ____3___ 개
- BottomNavigationView 설정하기
    - 각 Item을 클릭했을 때 나타나는 이벤트 설정하기
        - `setOnItemSelectedListener`를 사용하여 `BottomNavigationView`의 아이템 클릭 이벤트를 설정할 수 있다.
            
            ```kotlin
            val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
            
            bottomNavigationView.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.home -> {
                        // Home Fragment 표시
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, HomeFragment())
                            .commit()
                        true
                    }
                    R.id.profile -> {
                        // Profile Fragment 표시
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, ProfileFragment())
                            .commit()
                        true
                    }
                    else -> false
                }
            }
            ```
            
    - BottomNavigationView의 주요 속성들을 정리해 주세요!
        
        
        | 속성 | 설명 |
        | --- | --- |
        | `app:menu` | 사용할 메뉴 리소스 지정 |
        | `app:itemIconTint` | 아이콘 색상 설정 |
        | `app:itemTextColor` | 텍스트 색상 설정 |
        | `app:labelVisibilityMode` | 라벨 표시 방식 (`auto`, `labeled`, `unlabeled`) |
        | `app:background` | 배경 색상 설정 |
        | `app:itemRippleColor` | 클릭 시 리플 효과 색상 설정 |
        | `app:itemHorizontalTranslationEnabled` | 아이템 클릭 시 애니메이션 활성화 여부 |
    - 각 Item을 클릭했을 때 나타나는 이벤트 설정 방법은 꼭 정리하기 **[필수]**

## 🕑 2주차 Essential

---

### Activity & Fragment 존재 이유

`Activity`와 `Fragment`는 안드로이드 앱 UI를 나타내는 기본이자 필수적인 요소입니다.

화면을 표시해주는 기본 단위인데 안드로이드가 탄생하고 나서 2개가 공존했던 것은 아닙니다.

사실은 `Activity`가 먼저 존재했고 단점을 커버하기 위해서 `Fragment`가 뒤이어서 등장하게 된 개념입니다. 여기서 자연스럽게 스마트폰이 나오고 나서 어떤 문제가 있었길래 보완책으로 나온 걸까요?

스마트폰 초기 당시에는 화면에 표시할 UI가 그리 복잡하지 않았습니다. 지금이야 카카오톡부터 시작해서 우리가 평소에 사용하는 앱에는 정말 다양한 메뉴와 위젯들이 존재하지만 과거에는 그러지 않았습니다. 

또한, 스마트폰 디바이스뿐만 아니라 태블릿이라는 기기도 나오면서 화면의 요소가 더욱 많아졌고 효율성을 위해 재사용이 가능한 `Fragment`가 나온 것입니다.

![image.png](Chapter%202%20Activity%E1%84%8B%E1%85%AA%20Fragment%201beb57f4596b80e4be41dd98cc1368c9/image.png)

![image.png](Chapter%202%20Activity%E1%84%8B%E1%85%AA%20Fragment%201beb57f4596b80e4be41dd98cc1368c9/image%201.png)

예를 들어, 검색을 하든 글을 작성하든 어떤 UI에서도 공통으로 존재해야만 하는 위젯들이 있습니다.

단순히 로그아웃을 하는 상황에서조차 사용자에게 정말 로그아웃을 할 것인지 재확인하는 dialog, menu 등 다양한 요소가 있는데 `Activity`로만 해결하기에는 복잡해지기 때문에 `DialogFragment`라든지 `NavigationDrawer` 같은 요소들이 `Fragment` 단위로 `Activity`에 **종속**되는 구조로 이루어져있습니다. 여기서 **종속**에 대한 자세한 이야기는 `LifeCycle`을 다루는 다른 챕터에서 다루도록 하겠습니다.

더군다나 `Activity`가 `Fragment`보다 메모리 소모가 크기에 2018년 구글에서 `SAA(Single Activity Architecture)`를 공식적으로 발표했을 정도로 이 2가지를 적절히 사용해야만 합니다. 이 아키텍쳐에 관련해서 자세한 내용은 Superior 파트에서 다루도록 하겠습니다.

### Activity & Fragment 사용 예시

Chapter 1에서 앱의 구성 요소에 대해서 알아보셨다면 대표적인 요소가 4가지가 있다고 들어보셨을 것입니다.

<aside>
<img src="Chapter%202%20Activity%E1%84%8B%E1%85%AA%20Fragment%201beb57f4596b80e4be41dd98cc1368c9/android.png" alt="Chapter%202%20Activity%E1%84%8B%E1%85%AA%20Fragment%201beb57f4596b80e4be41dd98cc1368c9/android.png" width="40px" />

[`Activity`](https://developer.android.com/reference/android/app/Activity?hl=ko)의 각 서브클래스의 [`<activity>](https://developer.android.com/guide/topics/manifest/activity-element?hl=ko)
[Service](https://developer.android.com/reference/android/app/Service?hl=ko)`의 각 서브클래스의 [`<service>](https://developer.android.com/guide/topics/manifest/service-element?hl=ko)
[BroadcastReceiver](https://developer.android.com/reference/android/content/BroadcastReceiver?hl=ko)`의 각 서브클래스의 [`<receiver>](https://developer.android.com/guide/topics/manifest/receiver-element?hl=ko)
[ContentProvider](https://developer.android.com/reference/android/content/ContentProvider?hl=ko)`의 각 서브클래스의 [`<provider>`](https://developer.android.com/guide/topics/manifest/provider-element?hl=ko)

</aside>

공식문서에서는 `manifest`의 구성 요소, 다시 말해서 앱의 기본 구성 컴포넌트로 다음과 같이 4가지로 소개를 해줬는데요, Chapter 1에서 언급했지만 Fragment라는 개념은 Activity 이후에 나왔고 앱의 기본 단위는 여전히 Activity라는 것에는 변화가 없습니다.

```kotlin
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.toyou.toyouandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
```

MainActivity 코드에서 가장 중요한 `onCreate` 메서드에 대한 자세한 설명은 LifeCycle을 다루는 챕터에서 해드릴 예정이고 간단하게 말씀을 드리자면 Activity가 갑자기 하늘에서 뚝 떨어지면서 생성되는 것이 아니라 생명주기라는 순환구조를 통해서 탄생(`create`)과 소멸(`destroy`)을 반복하면서 메모리를 쓰는 양상을 보여줍니다.

```xml
<androidx.fragment.app.FragmentContainerView>
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/fragment_container_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
</androidx.fragment.app.FragmentContainerView>
```

공식문서에 소개되어있는 XML을 예시로 들자면 `FragmentContainerView`가 존재합니다. 

이전 Chapter에서 `ConstraintLayout, LinearLayout` 등등 다양한 레이아웃을 접하셨을 건데요, `FrameLayout`이라는 것도 존재하여 `Activity`에 `Fragment`를 띄울 수 있는 패턴을 많이 사용했습니다.

여기서 FragmentContainerView는 이름 그대로 Fragment를 위해서만 특별히 설계된 레이아웃이라는 것을 유추하실 수 있을 것 같습니다. 실제 프로젝트에서 사용되었던 `MainActivity의 layout`을 소개해드리면 다음과 같습니다.

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout 
		android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context=".presentation.base.MainActivity"
    xmlns:android="http://schemas.android.com/apk/res/android">

    <androidx.fragment.app.FragmentContainerView
        android:id="@+id/fragment_container"
        android:name="androidx.navigation.fragment.NavHostFragment"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        app:defaultNavHost="true"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintBottom_toTopOf="@id/bottom_navi"
        app:navGraph="@navigation/nav_graph" />

    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottom_navi"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:labelVisibilityMode="unlabeled"
        app:layout_constraintBottom_toBottomOf="parent"
        app:menu="@menu/bottom_navi_item"
        app:itemRippleColor="@null"
        app:itemActiveIndicatorStyle="@null"
        android:background="@color/white"
        app:itemIconTint="@drawable/bottom_navigation_color"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```

코드를 보면 `ConstraintLayout` 안에 `FragmentContainerView, BottomNavigationView`이 존재하는 것을 보실 수 있습니다. 이걸 보고서 아래 그림과 같은 구조를 상상하셨다면 정말 잘하셨습니다.

FragmentContainerView 안에 `navGraph`라든지 `defaultNavHost`는 Superior 파트에서 `SAA`를 다룰 때 더 자세히 설명해드리도록 하겠습니다.

![image.png](Chapter%202%20Activity%E1%84%8B%E1%85%AA%20Fragment%201beb57f4596b80e4be41dd98cc1368c9/image%202.png)

그림을 예시로 들어서 설명을 드리면 Content에 해당하는 부분이 당근마켓, 번개장터에서 물품목록, 홈화면을 채우고 있고 Footer에 해당하는 부분이 버튼들로 구성되어있는 BottomNavigationView라는 것입니다. ~~물론, Content, Footer는 이해를 돕기 위한 용어이고 안드로이드 용어는 아님을 알려드립니다.~~

### BottomNavigationView란?

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">

    <item
        android:id="@+id/navigation_home"
        android:icon="@drawable/lets_icons_home"
        android:title="" />

    <item
        android:id="@+id/navigation_social"
        android:icon="@drawable/lucide_pencil_line"
        android:title="" />

    <item
        android:id="@+id/navigation_record"
        android:icon="@drawable/quill_calendar"
        android:title="" />

    <item
        android:id="@+id/navigation_mypage"
        android:icon="@drawable/flowbite_user_outline"
        android:title=""
        />

</menu>
```

코드를 보시게 되면 `menu`태그에 `item`들이 들어가있는 모습을 보실텐데요 menu를 관장하는 다음 파일이 BottomNavigationView의 속성으로 정의되는 구조입니다.

```kotlin
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.toyou.toyouandroid.R
import com.toyou.toyouandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment

        val navController = navHostFragment.navController

        // BottomNavigationView 설정
        binding.bottomNavi.setupWithNavController(navController)

        // BottomNavigationView 아이템 선택 리스너 설정
        binding.bottomNavi.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    navController.navigate(R.id.navigation_home)
                    true
                }
                R.id.navigation_social -> {
                    navController.navigate(R.id.navigation_social)
                    true
                }
                R.id.navigation_record -> {
                    navController.navigate(R.id.navigation_record)
                    true
                }
                R.id.navigation_mypage -> {
                    navController.navigate(R.id.navigation_mypage)
                    true
                }
                else -> false
            }
        }
    }

    fun hideBottomNavigation(state:Boolean){
        if(state) binding.bottomNavi.visibility = View.GONE else binding.bottomNavi.visibility=View.VISIBLE
    }
}
```

저희가 위에서 MainActivity의 layout 안에 FragmentContainerView와 BottomNavigationView가 존재했었다는 것을 확인했었습니다.

자, `data binding`을 통해서 `MainActivity.kt`에서 이 2개의 `View`를 조작할 수 있게 됩니다.

그래서 `setOnClickListener`를 통해서 사용자가 클릭한 아이템에 따라서 어딘가로 `navigate`, 즉 방향을 가리키고 있다는 정도는 아실 수 있을 것입니다.

## 🔥 미션

---

## ✅ 2주차 실전미션

---

<aside>
💡 실전미션을 통해 Demoday를 대비해보자!

- [x]  `bottomNavigationView` 아이콘 색깔 변경하기
- [x]  `bottomNavigationView`에서 `fragment` 전환시
(예시: 홈화면→검색화면으로 넘어가기 위해 검색 아이콘을 클릭할 경우) 
본인이 원하는 애니메이션 효과 구현해보기
(예시: `slide effect`, `fade in/out effect` 등등…)
- 실전에서 사용할 때도 기본 템플릿을 가져다가 쓰지만 
팀마다 디자인이 다르므로 결국 각자 Customizing을 할 수밖에 없겠죠?
직접 디자인을 커스텀하면서 조작법에 익숙해져봅시다!
본인이 평소에 사용하는 앱의 `bottomNavigationView`를 참고하셔도 됩니다!
(예시: 당근마켓, 번개장터, 무신사 등등…)
- 본인이 평소에 원하는 앱이 없을 경우 아래의 Figma에 있는 BottomNavigationView를 선택하셔도 좋습니다.

[https://www.figma.com/design/h83YiY3y5BC74AI2YKIfe1/UMC-7th-Android-2nd-MIssion?node-id=0-1&node-type=canvas&t=2EwpNQd63CW4SQZM-0](https://www.figma.com/design/h83YiY3y5BC74AI2YKIfe1/UMC-7th-Android-2nd-MIssion?node-id=0-1&node-type=canvas&t=2EwpNQd63CW4SQZM-0)

- [x]  `SplashActivity` 만들어보기
- 아래의 그림과 같이 앱을 처음 실행할 때 등장하는 Splash 화면 만들기

![Untitled](Chapter%202%20Activity%E1%84%8B%E1%85%AA%20Fragment%201beb57f4596b80e4be41dd98cc1368c9/Untitled%201.png)

</aside>

## 📋 2주차 개발일지

---

<aside>
💡 미션 수행하신 내용을 아래에 정리해주세요!

</aside>

![Screenshot_1742904277.png](Chapter%202%20Activity%E1%84%8B%E1%85%AA%20Fragment%201beb57f4596b80e4be41dd98cc1368c9/Screenshot_1742904277.png)

![Screenshot_1742904639.png](Chapter%202%20Activity%E1%84%8B%E1%85%AA%20Fragment%201beb57f4596b80e4be41dd98cc1368c9/Screenshot_1742904639.png)

![Screenshot_1742904021.png](Chapter%202%20Activity%E1%84%8B%E1%85%AA%20Fragment%201beb57f4596b80e4be41dd98cc1368c9/Screenshot_1742904021.png)

![Screenshot_1742904729.png](Chapter%202%20Activity%E1%84%8B%E1%85%AA%20Fragment%201beb57f4596b80e4be41dd98cc1368c9/Screenshot_1742904729.png)

![Screenshot_1742904732.png](Chapter%202%20Activity%E1%84%8B%E1%85%AA%20Fragment%201beb57f4596b80e4be41dd98cc1368c9/Screenshot_1742904732.png)

![Screenshot_1742904735.png](Chapter%202%20Activity%E1%84%8B%E1%85%AA%20Fragment%201beb57f4596b80e4be41dd98cc1368c9/Screenshot_1742904735.png)

## ⚡ 트러블 슈팅

---

<aside>
💡 실습하면서 생긴 문제들에 대해서, **이슈 - 문제 - 해결** 순서로 작성해주세요.

</aside>

<aside>
💡 스스로 해결하기 어렵다면? 스터디원들에게 도움을 요청하거나 **너디너리의 지식IN 채널에 질문**해보세요!

</aside>

- ⚡이슈 No.1
    
    **`이슈`**
    
    👉 Splash 화면에 사진을 첨부했는데 화면 비율이 깨지는 문제가 발생했다.
    
    **`문제`**
    
    👉 디버깅이나 컴파일 등의 실행 자체에는 문제가 없지만, 샤진이 깨지는 문제가 발생했다.
    
    **`해결`**
    
    👉  (해결해 나아가는 중)
    
    **`참고레퍼런스`**
    
    [스플래시 화면 구현을 Android 12 이상으로 이전  |  Views  |  Android Developers](https://developer.android.com/develop/ui/views/launch/splash-screen/migrate?hl=ko)
    

## 🤔 참고 자료

---

[활동 소개  |  Android 개발자  |  Android Developers](https://developer.android.com/guide/components/activities/intro-activities?hl=ko)

[프래그먼트  |  Android 개발자  |  Android Developers](https://developer.android.com/guide/fragments?hl=ko)

[인텐트 및 인텐트 필터  |  Android 개발자  |  Android Developers](https://developer.android.com/guide/components/intents-filters?hl=ko)

[[Android] 안드로이드 - 명시적 인텐트(Explicit Intent)와 암시적 인텐트 (Implicit Intent)](https://lktprogrammer.tistory.com/160)

[https://www.youtube.com/watch?v=wJK3sSKUCFc](https://www.youtube.com/watch?v=wJK3sSKUCFc)

[Fragment Result API](https://moon-i.tistory.com/entry/Fragment-Result-API?category=984376?category=984376)

[](https://developer.android.com/guide/fragments/communicate?hl=ko#fragment-result)

[Material Design](https://material.io/design)

---

Copyright © 2025 Daemon(정승원) All rights reserved.