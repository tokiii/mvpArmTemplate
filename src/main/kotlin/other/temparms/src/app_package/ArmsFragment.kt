package other.temparms.src.app_package

import other.temparms.ArmsPluginTemplateProviderImpl

fun armsFragment(provider: ArmsPluginTemplateProviderImpl) = """
package ${provider.fragmentPackageName.value}

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ${provider.appPackageName.value}.base.MyBaseFragment
import com.jess.arms.di.component.AppComponent
import ${provider.componentPackageName.value}.Dagger${provider.pageName.value}Component
import ${provider.moudlePackageName.value}.${provider.pageName.value}Module
import ${provider.contractPackageName.value}.${provider.pageName.value}Contract
import ${provider.presenterPackageName.value}.${provider.pageName.value}Presenter

import ${provider.appPackageName.value}.R
import ${provider.appPackageName.value}.base.MyBaseActivity
import com.jess.arms.utils.ArmsUtils


/**
 * 如果没presenter
 * 你可以这样写
 *
 * @FragmentScope(請注意命名空間) class NullObjectPresenterByFragment
 * @Inject constructor() : IPresenter {
 * override fun onStart() {
 * }
 *
 * override fun onDestroy() {
 * }
 * }
 */
class ${provider.pageName.value}Fragment : MyBaseFragment<${provider.pageName.value}Presenter>() , ${provider.pageName.value}Contract.View{
    companion object {
    fun newInstance():${provider.pageName.value}Fragment {
        val fragment = ${provider.pageName.value}Fragment()
        return fragment
    }
    }


    override fun setupFragmentComponent(appComponent:AppComponent) {
        Dagger${provider.pageName.value}Component //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .${provider.pageName.value[0].toLowerCase()}${provider.pageName.value.substring(1, provider.pageName.value.length)}Module(${provider.pageName.value}Module(this))
                .build()
                .inject(this)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):View{
        return inflater.inflate(R.layout.${provider.fragmentLayoutName.value}, container, false);
    }

    /**
     * 在 onActivityCreate()时调用
     */
    override fun initData(savedInstanceState:Bundle?) {

    }


    override fun setData(data:Any?) {

    }

    override fun initView() {

    }
    
     override fun showLoading() {
        (activity as MyBaseActivity).showLoadingDialog()
    }

    override fun hideLoading() {
        (activity as MyBaseActivity).hideLoadingDialog()
    }

    override fun showMessage(message: String) {
        showToastMessage(message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {
           
    }
}
    
    
"""