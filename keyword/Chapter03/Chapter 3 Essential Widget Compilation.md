# Chapter 3. Essential Widget Compilation

---

<aside>
💡 **워크북 가이드라인**
1️⃣ 키워드 Essential은 자기주도학습!
2️⃣ 강의를 수강하고 나서 미션 수행하면서 트러블 슈팅 과정을 꼭! 정리해서 팀원들과 공유해보세요!
3️⃣ 주차별 Esssential은 권장이 아니라 필독입니다~
4️⃣ Essential에서 자세히 다루지 않은 내용은 레퍼런스 확인하셔서 살을 붙이시면 됩니다!

</aside>

---

---

## 📝 학습 목표

---

- BottomNavigationView을 구성하고 사용할 수 있다.
- TabLayout을 구성하고 사용할 수 있다.
- ViewPager2를 구성하고 사용할 수 있다.
- Adapter가 무엇인지 알고 사용할 수 있다.

## ⚠️ 스터디 진행 방법

---

1. 스터디를 진행하기 전, 워크북 내용들을 모두 채우고 스터디에서는 서로 모르는 내용들을 공유해주세요.
2. 미션은 워크북 내용들을 모두 완료하고 나서 스터디 전/후로 진행해보세요.
3. 다음주 스터디를 진행하기 전, 지난주 미션을 서로 공유해서 상호 피드백을 진행하시면 됩니다.

## ✨ 파트장이 남기는 말

---

이번 주차에서는 ViewPager2, TabLayout, BottomNavigationView 등의 유용한 위젯을 공부합니다.  여러분이 알고 있다면 개발할 때 많은 도움이 될 내용이니 추가로 어떤 유용한 위젯들이 있는지 알아보면 좋을 것 같습니다. 참고 자료에도 여러분들이 읽어보면 좋을 것 같은 자료들을 넣어 놓았으니 확인해 보세요!!

ViewPager2에서 다루게 되는 Adapter 개념을 공부하는 것만으로도 충분하기 때문에 3주차는 실전 미션이 존재하지 않으니 FLO 앱에서 클론 코딩하면서 감을 익히시는 것을 추천드립니다!

한 번 공부하신 적이 있거나 쉽다고 느껴지시는 분들께서는 아래의 내용을 추가로 공부해 보시는 것을 추천해 드립니다.

- CollapsingToolbarLayout
- CardView
- Floating Button
- Jetpack Navigation Graph

## 🎯 키워드 Essential

---

<aside>
💡 주요 내용들에 대해 조사해보고, 자신만의 생각을 통해 정리해보세요!
강의와 레퍼런스를 참고하여 정의, 속성, 장단점 등을 적어주셔도 됩니다.
조사는 공식 홈페이지 **Best**, 블로그(최신 날짜) **Not Bad**

</aside>

- TabLayout
    - TabLayout이란 무엇이고, 어떤 기능을 할까요?
        - 탭을 보여주는 horizontal 레이아웃.
        - 여러 개의 탭으로 구성되며 각 탭은 이름과 아이콘을 가진다.
        - 탭을 터치하는 등 상호작용을 통해 각 탭과 연결된 Activity 혹은 Fragment로 이동한다.
        - 이전 주차에 학습했던 바텀 네비게이션 바는 탭 레이아웃의 일종이라고 볼 수 있다.
        - [**addOnTabSelectedListener(OnTabSelectedListener)](https://developer.android.com/reference/com/google/android/material/tabs/TabLayout#addOnTabSelectedListener(com.google.android.material.tabs.TabLayout.OnTabSelectedListener))** 함수로 탭을 선택했을 때의 상호작용을 정의한다.
    
    - TabLayout이 사용된 예시에는 무엇이 있을까요?
    - 카카오톡의 쇼핑 탭과 북적북적의 내 서재에 TabLayout이 사용되었다.
        
        ![KakaoTalk_Photo_2025-04-01-17-48-44 001.jpeg](Chapter%203%20Essential%20Widget%20Compilation%201c5b57f4596b80f393b5c08017ee9d73/KakaoTalk_Photo_2025-04-01-17-48-44_001.jpeg)
        
    
    ![KakaoTalk_Photo_2025-04-01-17-48-45 002.jpeg](Chapter%203%20Essential%20Widget%20Compilation%201c5b57f4596b80f393b5c08017ee9d73/KakaoTalk_Photo_2025-04-01-17-48-45_002.jpeg)
    
    - TabLayout에서 사용할 수 있는 속성들은 무엇이 있을까
        
        
        | 속성 | 설명 | 예제 |
        | --- | --- | --- |
        | `app:tabMode` | 탭 배치 방식 (`fixed` or `scrollable`) | `app:tabMode="fixed"` |
        | `app:tabGravity` | 탭 정렬 방식 (`fill` or `center`) | `app:tabGravity="fill"` |
        | `app:tabIndicatorColor` | 탭 선택 시 밑줄 색상 | `app:tabIndicatorColor="@color/blue"` |
        | `app:tabIndicatorHeight` | 탭 선택 시 밑줄 높이 | `app:tabIndicatorHeight="4dp"` |
        | `app:tabSelectedTextColor` | 선택된 탭 텍스트 색상 | `app:tabSelectedTextColor="@color/black"` |
        | `app:tabTextColor` | 기본 탭 텍스트 색상 | `app:tabTextColor="@color/gray"` |
        | `app:tabIndicatorFullWidth` | 인디케이터(밑줄) 너비 설정 (`true` or `false`) | `app:tabIndicatorFullWidth="false"` |
        | `app:tabRippleColor` | 탭 클릭 시 효과 색상 | `app:tabRippleColor="@null"` |
- ViewPager2
    - ViewPager란 무엇이고, 어떤 기능을 할까요?
        - 사용자가 좌우 혹은 상하로 스와이프해서 페이지(프래그먼트 혹은 뷰)를 바꿀 수 있게 하는 위젯
        - RecyclerView 기반이라 동적 스크롤도 구현할 수 있다.
        - TabLayout과 결합해 사용할 때에는 뷰를 누르는 것 없이 스와이프만으로 뷰를 전환할 수 있게 함.
    - ViewPager가 사용된 예시에는 무엇이 있을까요?
        - 보통의 온보딩 스크린에서는 보통 좌우 화살표 또는 페이지를 넘기는 버튼이 있지만 스와이프로도 페이지를 바꿀 수 있음.
        - 앱 상단에 보통 존재하는 배너에서도 보통은 일정 시간이 지나면 자동으로 다음으로 넘어가게 설정되어 있으나 스와이프로도 배너를 변경할 수 있음.
    - ViewPager와 ViewPager2의 차이는 무엇일까요?
        
        
        |  | ViewPager | ViewPager2 |
        | --- | --- | --- |
        | **스크롤 방향** | **좌↔우 스크롤만 가능** | **위↕아래 스크롤 가능** (`setOrientation()`) |
        | **어댑터** | `PagerAdapter`, `FragmentPagerAdapter`, `FragmentStatePagerAdapter` | **`FragmentStateAdapter` (RecyclerView 기반)** |
        | **프래그먼트 관리** | 전체 프래그먼트를 메모리에 유지 | 필요할 때만 **로드 & 삭제 (메모리 절약)** |
        | **RecyclerView 지원** | ❌ 불가능 | ✅ `RecyclerView` 기반이라 **리스트 뷰와 유사하게 동작** |
        | **RTL(오른쪽 → 왼쪽) 지원** | ❌ 불가능 | ✅ 가능 (`android:layoutDirection="rtl"`) |
        | **페이지 변경 애니메이션** | 제한적 (`PageTransformer`) | 더 부드럽고 다양한 애니메이션 가능 |
        | **데이터 변경 반영** | `notifyDataSetChanged()`로 업데이트 어려움 | `notifyItemChanged()`, `notifyItemInserted()` 가능 |
        | **탭과 연결** | `TabLayout.setupWithViewPager()` 사용 | `TabLayoutMediator` 사용 |
    - ViewPager2에서 사용할 수 있는 속성들은 무엇이 있을까요?
        - android:orientation: 스와이프 방향 설정
        - `registerOnPageChangeCallback()`  콜백으로 페이지 변경을 감지.
        - RecyclerView 기반 동작
            - `FragmentStateAdapter` : 리사이클러뷰 기반 어댑터 사용
            - `notifyItemChanged(n)`:  n번째 항목만 변경
            - `notifyItemInserted(n)` : n번째에 항목 추가
- ViewPager2 설정하기
    - ViewPager2를 이용하기 위해 어떤 라이브러리를 사용해야 할까요
        
        ```kotlin
        dependencies {
        		// ViewPager2
            implementation 'androidx.viewpager2:viewpager2:1.0.0'
            
            // TabLayout
            implementation 'com.google.android.material:material:1.10.0'
        }
        ```
        
        - XML에 들어가야 하는 속성도 작성
            
            ```kotlin
            // TabLayout
            <com.google.android.material.tabs.TabLayout
                android:id="@+id/tabLayout"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:background="?attr/colorPrimary"/>
            
            // ViewPager2
            <androidx.viewpager2.widget.ViewPager2
                android:id="@+id/viewPager"
                android:layout_width="match_parent"
                android:layout_height="match_parent"/>
            ```
            
            - TabLayout과 ViewPager2를 연결하기 위해 코드에서 TabLayoutMediator 설정해야 함.
                
                ```kotlin
                TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                    tab.text = when (position) {
                        0 -> "첫 번째"
                        1 -> "두 번째"
                        2 -> "세 번째"
                        else -> "기본"
                    }
                }.attach()
                ```
                
    - ViewPager2에서 FragmentStateAdapter는 무엇이고 어떤 기능을 할까요?
        - 각 페이지를 Fragment로 관리할 수 있도록 도와주는 어댑터.
        - 여러 개의 프래그먼트를 ViewPager2에서 스와이프하며 볼 수 있도록 연결.
        - 기능
            1. **`Fragment`를 동적으로 생성하고 관리**할 수 있음.
            2. **메모리 관리 최적화** → 사용하지 않는 프래그먼트는 제거되고, 다시 필요하면 새로 생성됨.
                
                (이전 `ViewPager`의 `FragmentPagerAdapter`보다 성능이 좋음!)
                
            3. `TabLayout`과 함께 사용하면 **탭을 클릭할 때마다 새로운 프래그먼트로 이동 가능**
- ViewPager2 Indicator 설정하기
    - Indicator란 무엇이고, 어떤 역할을 할까요?
        - 사용자가 현재 보고 있는 페이지가 무엇인지 시각적으로 알려주는 UI 요소
        - TabLayout에서 현재 선택된 탭에 가로선을 긋는 인디케이터
            
            ```kotlin
            <com.google.android.material.tabs.TabLayout
                android:id="@+id/tabLayout"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:tabIndicatorColor="@color/black"  // 인디케이터 색
                app:tabIndicatorHeight="4dp"/>  // 인디케이터 두께
            ```
            
        - ViewPager에서 현재 보고 있는 화면이 몇번째인지 알려주는 점 인디케이터
            
            ```kotlin
            <com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator
                android:id="@+id/dotsIndicator"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                app:dotsColor="@color/black" // 인디케이터 색
                app:dotsSize="10dp"/> // 인디케이터 크기
            ```
            
        - BottomNavigationView에서 현재 선택된 탭의 아이콘 뒤로 배경을 넣는 인디케이터
            
            ```kotlin
            <com.google.android.material.bottomnavigation.BottomNavigationView
                android:id="@+id/bottom_navigation"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:itemActiveIndicatorStyle="@null"/> // 인디케이터 색
            ```
            
    - ViewPager2에서 Indicator를 설정하려면 어떻게 해야할까요?
        - 점 인디케이터 속성을 편집한다.
        
        ```kotlin
        <com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator
            android:id="@+id/dotsIndicator"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:dotsColor="@color/black" // 인디케이터 색
            app:dotsSize="10dp"/> // 인디케이터 크기
        ```
        

## 🕒 3주차 Essential

---

### TabLayout & ViewPager2

Layout이라는 이름이 들어간 것으로 보아 이전 챕터에서 나왔었던 ConstraintLayout이 자연스럽게 떠오르실텐데요, 맞습니다.

그리고 ViewPager 뒤에 왜 숫자가 들어가는지도 궁금하실 것 같습니다. 

안드로이드의 대표적인 써드 파티 통신 라이브러리 중에서 Retrofit2라는 것도 있는데 숫자는 버전의 가장 최상단 번호를 의미합니다. 

보통 서비스를 Release할 때도 플레이스토어에 1.X.X 이런식으로 버전을 명명하는 것을 본 적이 한 번쯤은 있으실겁니다. 라이브러리에서도 똑같다고 생각하시면 됩니다.

[anim_screenslide.mp4](Chapter%203%20Essential%20Widget%20Compilation%201c5b57f4596b80f393b5c08017ee9d73/anim_screenslide.mp4)

`orientation` 속성으로 가로, 세로 모드를 모두 지원한다는 특징도 있습니다.

영상을 확인하시면서 떠오르실 법한 생각 중에서 한국이나 서양권은 책을 읽을 때 Left에서 Right 방향으로 넘기는데 일부 국가에서는 그 반대로 넘기는 경우가 있을 수도 있습니다.

UX적인 관점에서 `RTL` 지원도 해야하기 때문에 `layoutDirection` 속성을 통해 설정할 수 있습니다.

여기서 재밌는 사실은 이전 챕터에서 ConstraintLayout 실습을 진행하셨다면 제약 조건(Contstraint)을 부여할 때 `StartToStart`로 설정하는 것을 볼 수 있습니다. 

그런데 자동완성으로 `Left`라는 단어도 보셨을텐데요, 국가 간 문화적 차이로 인해서 안드로이드 측에서 Start를 권장하고 Left를 사용하게 되면 경고성 밑줄이 그어지는 것 또한 확인하실 수 있습니다.

이제, XML 코드를 살펴봅시다.

```xml
<com.google.android.material.tabs.TabLayout
            android:id="@+id/tabLayout"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="57dp"
            app:tabIndicatorFullWidth="false"
            app:tabIndicatorColor="@android:color/black"
            app:tabSelectedTextColor="@android:color/black"
            app:tabTextColor="@android:color/black"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:tabTextAppearance="@style/sc_r15">

            <com.google.android.material.tabs.TabItem
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/calendar_my_record" />

            <com.google.android.material.tabs.TabItem
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/calendar_friend_record" />

</com.google.android.material.tabs.TabLayout>
```

```kotlin
class RecordFragment : Fragment() {

    lateinit var navController: NavController
    private var _binding: FragmentRecordBinding? = null
    private val binding: FragmentRecordBinding
        get() = requireNotNull(_binding){"FragmentRecordBinding -> null"}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRecordBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        val tabLayout: TabLayout = binding.tabLayout

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> replaceFragment(CalendarMyRecordFragment())
                    1 -> replaceFragment(CalendarFriendRecordFragment())
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        // 초기 화면 설정
        if (savedInstanceState == null) {
            tabLayout.getTabAt(0)?.select()
            replaceFragment(CalendarMyRecordFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.commit {
            replace(R.id.record_fragment_Container, fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
```

사용자가 탭을 클릭(선택)하게 되면 각각의 탭에 맞는 `Fragment`로 전환되는 구조입니다.

`addOnTabSelectedListener`메서드를 통해서 탭이 클릭될 때마다 반응하는 리스너를 정의합니다.

또한, `savedInstanceState`인자를 통해서 초기 화면이 생성될 때 선택되어있을 탭을 지정할 수도 있습니다.

무조건 가장 왼쪽 방향의 탭이 첫 화면이 아니라 다른 탭을 첫 화면으로 설정하고 싶을 때는 수동으로 설정하는 것이 가능합니다.

예를 들어서 사진 목록이 있고 사진들을 ViewPager로 보여주고 싶을 때 사진 목록 내에서 사용자가 클릭한 사진부터 보여줘야 하기 때문에 추가 설정이 필요하고 TabLayout을 사용할 때도 마찬가지로 특수한 상황에서는 커스텀이 가능합니다.

[KakaoTalk_20240913_142527279.mp4](Chapter%203%20Essential%20Widget%20Compilation%201c5b57f4596b80f393b5c08017ee9d73/KakaoTalk_20240913_142527279.mp4)

[KakaoTalk_20240913_142338656.mp4](Chapter%203%20Essential%20Widget%20Compilation%201c5b57f4596b80f393b5c08017ee9d73/KakaoTalk_20240913_142338656.mp4)

전체 화면 구조에 대해 간략히 말씀드리자면 내 기록인지 친구 기록인지에 따라서 `TabLayout`으로 설정되어있고 `Tab Item`에서도 달력의 날짜들이 `ViewPager`로 설정되어있습니다. 

ViewPager가 이중으로 들어가있다고도 할 수 있는데 보통 앱 UI들이 복잡하기 때문에 이런 식으로 다중으로 들어가는 경우가 흔합니다.

이후 챕터에서 `RecyclerView`를 다루면서 Adapter에 관해서 자세히 풀어쓸 예정이지만 ViewPager도 RecyclerView 기반으로 만들어진 컴포넌트이기 때문에 RecyclerView Adapter를 사용한다는 특징이 있다.

다른 `View`와의 차별점은 ImageView, TextView 등등 여러 View들이 묶여서 하나의 `item`으로 존재한다는 것이 특징입니다. 

예를 들어서 친구 목록이 있다고 가정해보자. 

친구가 1000명이라고 했을 때 서버에서 받아온 정보를 바탕으로 1000개의 정보를 한꺼번에 갱신해서 미리 화면에 표시한다고 생각하면 무언가 이상한 점이 안 느껴지시나요?

`ANR(Application Not Responding)`이라는 것에 대해 언급하고 넘어가고 싶은데 가끔씩 앱을 사용하다가 의도치 않게 튕기는 경우가 있습니다. 

원인이 다양하게 존재하지만 ANR이 발생하는 요인 중에서 가장 쉽게 생각할 수 있는 경우는 화면에 과도하게 리소스를 출력하는 경우나 서버와 통신하는 과정에서 비동기 처리가 제대로 되지 않는 경우가 있을 것입니다.

RecyclerView나 ViewPager도 여러 개의 아이템을 표시해주는 것이기 때문에 대표적인 오류인 ANR을 포함해서 메모리 관점에서 더 효율적인 방법으로 재활용을 채택했습니다.

예시코드를 살펴보자.

```kotlin
class MyrecordCalendarPagerAdapter(
    private val datesList: List<List<MyDate>>,
    private val currentMonth: Int,
    private val onDateClickListener: MyRecordCalendarRVAdapter.OnDateClickListener
) : RecyclerView.Adapter<MyrecordCalendarPagerAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: CalendarPageBinding) : RecyclerView.ViewHolder(binding.root) {
        val calendarRecyclerView: RecyclerView = binding.calendarViewPager
        val dayOfTheWeekRecyclerView: RecyclerView = binding.dayOfTheWeekRecyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CalendarPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // 각 페이지의 RecyclerView에 CalendarAdapter를 설정하고, 해당 월의 날짜 데이터를 연결
    // GridLayoutManager를 사용하여 달력을 그리드 형식으로 표시
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val dates = datesList[position]
        val adapter = MyRecordCalendarRVAdapter(dates, currentMonth, onDateClickListener)

        holder.calendarRecyclerView.adapter = adapter
        holder.calendarRecyclerView.layoutManager = GridLayoutManager(holder.itemView.context, 7)

        val daysOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
        val dayOfWeekAdapter = DayOfTheWeekAdapter(daysOfWeek)
        holder.dayOfTheWeekRecyclerView.adapter = dayOfWeekAdapter
        holder.dayOfTheWeekRecyclerView.layoutManager = GridLayoutManager(holder.itemView.context, 7)
    }

    override fun getItemCount(): Int {
        return datesList.size
    }
}
```

`OnCreateViewHolder`에서는 새로운 ViewHolder 객체 인스턴스를 생성하는 역할을 하고 `binding`을 통해서 item의 레이아웃을 지정하게 됩니다.

사용자 화면에서 벗어나는 아이템은 다음 사진과 같이 갱신해서 보여주고 담는 그릇을 `ViewHolder`개념이라고 생각하시면 될 것 같습니다.

Adapter에 관한 자세한 내용은 추후 챕터에서 이어질 RecyclerView에서 다루도록 하겠습니다.

[ViewPager2를 사용하여 탭으로 스와이프 뷰 만들기  |  Android Developers](https://developer.android.com/guide/navigation/navigation-swipe-view-2?hl=ko)

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>

    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/dayOfTheWeek_recyclerView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            app:layout_constraintTop_toTopOf="parent" />

        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/calendarViewPager"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:overScrollMode="never"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@id/dayOfTheWeek_recyclerView" />

    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
```

여기서 `FrameLayout`이나 `ViewPager2`레이아웃을 사용하셔도 되고 무조건 ViewPager를 쓸 필요는 없습니다. 그래서 필자는 RecyclerView로 ViewPager를 구성했습니다.

아래와 같이 `scrollbars`속성을 추가해서 ViewPager2 위젯을 사용하셔도 무방합니다.

```xml
<!-- 월별 달력 -->
        <androidx.constraintlayout.widget.ConstraintLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_marginStart="16dp"
            android:layout_marginEnd="16dp"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@id/dayOfTheWeek_recyclerView"
            app:useMaterialThemeColors="false">

            <androidx.viewpager2.widget.ViewPager2
                android:id="@+id/calendarViewPager"
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:scrollbars="vertical"
                android:visibility="visible"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintHorizontal_bias="0.0"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintVertical_bias="0.0" />

        </androidx.constraintlayout.widget.ConstraintLayout>
```

## 🔥 미션

---

## ✅ 기본 체크리스트

---

- [x]  **실제 Flo앱과 흡사하게 만들었나요? - 단지 비슷해서만 되는게 아닙니다! 디자인을 실제 퍼블리싱하는 과정을 연습하는 것이기 때문에 다른 사람이 볼때 정말 플로어플인지 아닌지 헷갈릴 정도로 만들었는지 확인해주세요!**
- [x]  **비율 코딩이 잘 되어있나요? (xml 상의 기기를 바꿔보면서 비율코딩 확인)**
- [x]  **모든 View에 적절한 id(네이밍)을 매치했나요?**

---

## ✅ 3주차 미션 체크리스트

---

<aside>
💡 미션은 아래 내용을 확인해주세요!

- [x]  기존 파일에서 SongActivity와 AlbumFragment 추가하기
- [x]  실습에서 보여준 화면(XML)[노래재생](activity_song)[앨범정보](fragment_album)만들어오기
- [x]  Activity 전환(MainActivity ↔ SongActivity) 구현하기
    - 미니플레이어에 있는 제목과 가수명 SongActivity에 전달하기
    - SongActivity에서 MainActivity 로 돌아갈 때 데이터 넘겨주기
        - SongActivity에서 앨범의 제목을 String 타입으로 보내기
            - MainActivity 에서 String 타입의 값을 받으면 그 내용으로 Toast 메시지 띄우기
        - [참고] 다른 Activity로 이동했다가 돌아올 때 Data를 받을 수 있는 `registerForActivityResult` 사용 방법
            
            [registerForActivityResult 구현방법 정리 # 예전 onActivityResult](https://developer88.tistory.com/351)
            
    
    ![Untitled](Chapter%203%20Essential%20Widget%20Compilation%201c5b57f4596b80f393b5c08017ee9d73/Untitled.png)
    
- [x]  Fragment 전환(HomeFragment ↔ AlbumFragment) 구현하기‼️
    - Fragment 전환 시 HomeFragment에서 앨범의 데이터를 AlbumFragment로 전달하여 클릭한 앨범과 동일한 앨범이 나오도록 구현해보기
    - [참고]
        
        [[Android] Fragment / Activity간 데이터 주고받기](https://velog.io/@jinny_0422/Android-Fragment-Activity간-데이터전달)
        
    
    ![Untitled](Chapter%203%20Essential%20Widget%20Compilation%201c5b57f4596b80f393b5c08017ee9d73/Untitled%201.png)
    
</aside>

<aside>
💡 미션은 아래 내용을 확인해주세요!

- [x]  AlbumFragment 화면은 잘 만들었나요?
- [x]  Activity - Activity 간의 데이터 전달 및 클릭 시 이미지 변경
    - [SongActivity]화면 반복재생, 전체재생 이미지 교체해보기
    - [MainActivity]에 있는 MiniPlayer에 있는 데이터로 [SongActivity]화면 렌더링
    - [AlbumFragment]화면 내 취향 MIX 버튼 클릭시 이미지 변경해보기

![Untitled](Chapter%203%20Essential%20Widget%20Compilation%201c5b57f4596b80f393b5c08017ee9d73/Untitled%202.png)

![Untitled](Chapter%203%20Essential%20Widget%20Compilation%201c5b57f4596b80f393b5c08017ee9d73/Untitled%203.png)

1. Viewpager 구현하기
    - HomeFragment에서 banner 부분 Viewpager 구현하기
    - AlbumFragment 에 TabLayout + Viewpager 추가 구현하기
    - AlbumFragment Viewpager 에 DetailFragment, VideoFragment 구현하기
    - [Lock/erFragment] 화면 TabLayout과 Viewpager로 구현하기

![Untitled](Chapter%203%20Essential%20Widget%20Compilation%201c5b57f4596b80f393b5c08017ee9d73/Untitled%204.png)

![Untitled](Chapter%203%20Essential%20Widget%20Compilation%201c5b57f4596b80f393b5c08017ee9d73/Untitled%205.png)

![Untitled](Chapter%203%20Essential%20Widget%20Compilation%201c5b57f4596b80f393b5c08017ee9d73/Untitled%206.png)

1. Indicator 추가하기
    - [HomeFragment]화면Panel 부분 Viewpager로 구현해보고 Indicator 추가해보기
        - 오픈소스 라이브러리인 **CircleIndicator 활용**해서 슬라이드 만들어보기
        - 라이브러리 GitHub
        
        [https://github.com/ongakuer/CircleIndicator](https://github.com/ongakuer/CircleIndicator)
        
    - 일정 시간 후 다음 화면으로 넘어가는 자동 슬라이드 구현해보기
        
        ![Untitled](Chapter%203%20Essential%20Widget%20Compilation%201c5b57f4596b80f393b5c08017ee9d73/Untitled%207.png)
        
</aside>

## 📋 3주차 개발일지

---

<aside>
💡 미션 수행하신 내용을 아래에 정리해주세요!

</aside>

- circle indicator는 라이브러리를 모듈로 등록?하면 xml에서 인식을 못했다.. 라이브러리를 직접 넣으니까 잘 작동한다!
- 강의와 현재 플로 앱의 ui가 다른 부분이 있었다.
- noto sans kr 폰트를 추가해서 사용했는데, 원하는 스타일을 맞추기 위해서 xml을 4줄씩이나 더 써야 하는 점이 걸린다. fontFamily 설정한 파일에서 한번에 조정할 수 있을 것 같아서 찾아보고자 한다. 매번 똑같이 letterSpacing이나 includeFontPadding 설정하니까 코드가 너무 길어진다ㅜ
- Constraint로만 UI 위치를 설정하는 게 좋을지 LinearLayout을 적극 채용해야 하는지 고민이다. 강의록에서도 LinearLayout을 많이 사용했는데, 코드는 길지만 그룹으로 관리가 편했다.
- 강의에서 함께 만든 BannerVPAdapter과 미션을 위해 만든 PanelVPAdpater의 코드가 완전히 같았는데, 같은 클래스로 각자 인스턴스 만들어서 사용할 수 있지 않을까.. 하는 생각을 했다.
- 자동으로 panel이 넘어가는 것까진 만들지 못했다..ㅜ
- 플레이리스트 이름 짓기는 챗지피티에게 외주를 줬는데, 생각보다 잘 못지었다. flo 식으로 길게 지어줬으면 했는데 자꾸 짧게 지어줘서 유튜브에 있는 플레이리스트 이름을 사용했다. 학습을 잘 시키면 flo 처럼 길게 지을 수 있을 것 같은데..

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
    

## 🤔 참고 자료

---

[https://www.youtube.com/watch?v=43GjRpeHd9w&feature=youtu.be](https://www.youtube.com/watch?v=43GjRpeHd9w&feature=youtu.be)

[https://www.youtube.com/watch?v=R1yeoFk-quU](https://www.youtube.com/watch?v=R1yeoFk-quU)

[https://www.youtube.com/watch?v=3o98y7h9dfE](https://www.youtube.com/watch?v=3o98y7h9dfE)

[https://www.youtube.com/watch?v=FJvUKLNx6nw](https://www.youtube.com/watch?v=FJvUKLNx6nw)

[Android BottomNavigationView 사용하기 |](https://thdev.tech/androiddev/2016/12/16/Android-BottomNavigationView-Intro/)

[ViewPager로 프래그먼트 간 슬라이드  |  Android 개발자  |  Android Developers](https://developer.android.com/training/animation/screen-slide?hl=ko)

---

Copyright © 2025 Daemon(정승원) All rights reserved.