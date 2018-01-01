package com.test;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

import com.platform.action.MenuAction;
import com.platform.action.MenuRoleAction;
import com.platform.action.MenuUnitAction;
import com.platform.action.MenuUserAction;
import com.platform.action.MenuVipAction;
import com.platform.action.RoleAction;
import com.platform.action.RoleUserAction;
import com.platform.action.RoleVipAction;
import com.platform.action.TradeTypeAction;
import com.platform.action.UnitInfoAction;
import com.platform.action.UserAction;
import com.platform.action.VipAction;
import com.test.action.AddressInfoAction;
import com.test.action.AppHomePageAction;
import com.test.action.AppStartPageAction;
import com.test.action.AudioFileAction;
import com.test.action.CertificateInfoAction;
import com.test.action.ChangeTimeAction;
import com.test.action.CollectBusinessAction;
import com.test.action.CollectCommodityAction;
import com.test.action.EvaluateInfoAction;
import com.test.action.ExceptionOrderAction;
import com.test.action.FeedBackInfoAction;
import com.test.action.IDCardAction;
import com.test.action.SystemMessageAction;
import com.test.action.VipBalanceAction;
import com.test.action.VipConsumptionRecordAction;
import com.test.action.VipEarnRecordAction;
import com.test.action.VipSendAddressAction;



public class AppRoute implements ISparkApplication{

	@Auto(name=MenuAction.class)
	private MenuAction menuAction;
	
	@Auto(name=MenuUnitAction.class)
	private MenuUnitAction menuUnitAction;
	
	@Auto(name=MenuRoleAction.class)
	private MenuRoleAction menuRoleAction;
	
	@Auto(name=MenuUserAction.class)
	private MenuUserAction menuUserAction;
	
	@Auto(name=MenuVipAction.class)
	private MenuVipAction menuVipAction;
	
	@Auto(name=RoleAction.class)
	private RoleAction roleAction;
	
	@Auto(name=RoleUserAction.class)
	private RoleUserAction roleUserAction;
	
	@Auto(name=RoleVipAction.class)
	private RoleVipAction roleVipAction;
	
	@Auto(name=TradeTypeAction.class)
	private TradeTypeAction tradeTypeAction;
	
	@Auto(name=UnitInfoAction.class)
	private UnitInfoAction unitAction;
	
	@Auto(name=UserAction.class)
	private UserAction userAction;
	
	@Auto(name=VipAction.class)
	private VipAction vipAction;
	
	@Auto(name=AddressInfoAction.class)
	private AddressInfoAction addressInfoAction;
	
	

	@Auto(name=AudioFileAction.class)
	private AudioFileAction audioFileAction;
	
	
	@Auto(name=CertificateInfoAction.class)
	private CertificateInfoAction certificateInfoAction;
	
	@Auto(name=IDCardAction.class)
	private IDCardAction idCardAction;
	
	@Auto(name=VipConsumptionRecordAction.class)
	private VipConsumptionRecordAction vipConsumptionRecordAction;
	
	@Auto(name=VipBalanceAction.class)
	private VipBalanceAction vipBalanceAction;
	
	@Auto(name=VipSendAddressAction.class)
	private VipSendAddressAction vipSendAddressAction;
	
	@Auto(name=CollectBusinessAction.class)
	private CollectBusinessAction collectBusinessAction;
	
	@Auto(name=CollectCommodityAction.class)
	private CollectCommodityAction collectCommodityAction;
	
	@Auto(name=AppHomePageAction.class)
	private AppHomePageAction appHomePageAction;
	
	@Auto(name=EvaluateInfoAction.class)
	private EvaluateInfoAction evaluateInfoAction;
	
	@Auto(name=AppStartPageAction.class)
	private AppStartPageAction appStartPageAction;
	
	@Auto(name=VipEarnRecordAction.class)
	private VipEarnRecordAction vipEarnRecordAction;
	
	@Auto(name=ChangeTimeAction.class)
	private ChangeTimeAction changeTimeAction;
	
	@Auto(name=ExceptionOrderAction.class)
	private ExceptionOrderAction exceptionOrderAction;
	
	@Auto(name=FeedBackInfoAction.class)
	private FeedBackInfoAction feedBackInfoAction;
	
	@Auto(name=SystemMessageAction.class)
	private SystemMessageAction systemMessageAction;
	
	
	
	@Override
	public void run() {
		/**
		 * PC端访问入口
		 */
		menuAction.run();
		menuUnitAction.run();
		menuRoleAction.run();
		menuUserAction.run();
		menuVipAction.run();
		roleAction.run();
		roleUserAction.run();
		roleVipAction.run();
		tradeTypeAction.run();
		unitAction.run();
		userAction.run();
		vipAction.run();
		addressInfoAction.run();
		audioFileAction.run();
		certificateInfoAction.run();
		idCardAction.run();
		vipConsumptionRecordAction.run();
		vipBalanceAction.run();
		vipSendAddressAction.run();
		collectBusinessAction.run();
		collectCommodityAction.run();
		appHomePageAction.run();
		evaluateInfoAction.run();
		appStartPageAction.run();
		vipEarnRecordAction.run();
		changeTimeAction.run();
		exceptionOrderAction.run();
		feedBackInfoAction.run();
		systemMessageAction.run();
		/**
		 * 手机端访问入口
		 */
	}

}
