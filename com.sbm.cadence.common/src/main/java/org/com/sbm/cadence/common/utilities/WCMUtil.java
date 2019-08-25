package org.com.sbm.cadence.common.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

//
//import sa.gov.yesser.framework.utils.wcm.WcmWrapperException;
//
//import com.ibm.websphere.security.NotImplementedException;
//import com.ibm.workplace.wcm.api.Category;
//import com.ibm.workplace.wcm.api.Content;
//import com.ibm.workplace.wcm.api.ContentLink;
//import com.ibm.workplace.wcm.api.DocumentId;
//import com.ibm.workplace.wcm.api.DocumentIdIterator;
//import com.ibm.workplace.wcm.api.DocumentLibrary;
//import com.ibm.workplace.wcm.api.DocumentType;
//import com.ibm.workplace.wcm.api.DocumentTypes;
//import com.ibm.workplace.wcm.api.FileComponent;
//import com.ibm.workplace.wcm.api.ImageComponent;
//import com.ibm.workplace.wcm.api.LinkComponent;
//import com.ibm.workplace.wcm.api.OptionSelectionComponent;
//import com.ibm.workplace.wcm.api.RenderingContext;
//import com.ibm.workplace.wcm.api.RichTextComponent;
//import com.ibm.workplace.wcm.api.ShortTextComponent;
//import com.ibm.workplace.wcm.api.SiteArea;
//import com.ibm.workplace.wcm.api.TextComponent;
//import com.ibm.workplace.wcm.api.WCM_API;
//import com.ibm.workplace.wcm.api.Workspace;
//import com.ibm.workplace.wcm.api.exceptions.AuthorizationException;
//import com.ibm.workplace.wcm.api.exceptions.ComponentNotFoundException;
//import com.ibm.workplace.wcm.api.exceptions.DocumentIdCreationException;
//import com.ibm.workplace.wcm.api.exceptions.DocumentRetrievalException;
//import com.ibm.workplace.wcm.api.exceptions.IllegalDocumentTypeException;
//import com.ibm.workplace.wcm.api.exceptions.OperationFailedException;
//import com.ibm.workplace.wcm.api.exceptions.PropertyRetrievalException;
//import com.ibm.workplace.wcm.api.exceptions.ServiceNotAvailableException;
//import com.ibm.wsspi.security.auth.callback.WSMappingCallbackHandlerFactory;

/**
 * 
 * @author Haythem Alshaikh
 *
 */
public class WCMUtil {

//	private static final Log LOG = LogFactory.getLog(WcmUtils.class);

	private static WCMUtil INSTANCE;

//	private Workspace workspace;

	// private static ResourceBundle configBundle = null;

	// private Properties props = null;
	public static final String SPEPARATOR = "/";

	private class UserInfo {
		String userName;
		String userPassword;

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserPassword() {
			return userPassword;
		}

		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}

	}

	private WCMUtil() {

	}

	public synchronized static WCMUtil getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new WCMUtil();
		}
		return INSTANCE;
	}

//	public void start() throws WcmException {
//		if (workspace == null) {
//			UserInfo userInfo = getUserInfo();
//			try {
//				workspace = WCM_API.getRepository().getSystemWorkspace();/*
//																		 * getWorkspace
//																		 * (
//																		 * userInfo
//																		 * .
//																		 * getUserName
//																		 * (),
//																		 * userInfo
//																		 * .
//																		 * getUserPassword
//																		 * ());
//																		 */
//			} catch (ServiceNotAvailableException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (OperationFailedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//
//	}

	/**
	 * added by IT-BLOCKS Team
	 */

//	public Map<String, String> getTopic(String lang) {
//		start();
//		return getCategories(IWcmUtils.Category_Name_topic, lang, false, false);
//	}
//
//	public Map<String, String> getType(String lang) {
//		start();
//		return getCategories(IWcmUtils.Category_Name_type, lang, false, false);
//	}

	/**
	 * Government Agencies Directories By Mostafa
	 */
	// get all Government agency Types
	// used in GovBussines
//	public Map<String, String> getGovAgenciesTypes(String lang) {
//		start();
//		return getCategories(IWcmUtils.GovAgenciesDir_Types, lang, false, false);
//	}
//
//	public Map<String, String> getAllGovAgencies(String lang) {
//		start();
//		return getCategories(IWcmUtils.AllGovAgencies, lang, false, false);
//	}

//	public DocumentIdIterator searchOrganizContent(String parentCategory, String lang) {
//		// start();
//		return searchOrganizationsContent(parentCategory, lang);
//	}

	/**
	 * 
	 * @param parentCategory
	 * @param lang
	 * @return
	 */
	public int getNumberOfGovAgencies(String parentCategory, String lang) {
		int number = 0;
		try {
//			number = searchOrganizationsContent(parentCategory, lang).getCount();
		} catch (Exception ex) {
			number = 0;
		}
		return number;
	}

	// get all Government agencies under a specific type
	// used in GovBussines
//	public Map<String, Map<String, String>> getGovAgencies(String parentCategory, String lang, int start, int limit) {
//		Map<String, Map<String, String>> GovAgencies = null;
//		DocumentIdIterator docIdIter = searchOrganizationsContent(parentCategory, lang);
//		DocumentId wcmDocumentId = null;
//		try {
//			GovAgencies = new HashMap<String, Map<String, String>>();
//			int i = 0;
//			limit = start + limit;
//			while (docIdIter != null && docIdIter.hasNext()) {
//				wcmDocumentId = docIdIter.nextId();
//				if (i >= start) {
//					Content content = null;
//					if (workspace.getById(wcmDocumentId) instanceof ContentLink) {
//						ContentLink contentlink = (ContentLink) workspace.getById(wcmDocumentId);
//						content = (Content) workspace.getById(contentlink.getContentId());
//					} else {
//						content = (Content) workspace.getById(wcmDocumentId);
//					}
//					Map<String, String> dataMap = new HashMap<String, String>();
//					dataMap.put(content.getName(), content.getTitle());
//
//					// mohsen added hbere to get agency code
//					DocumentId<? extends Category>[] documentIds = content.getCategoryIds();
//					String orgCode = "";
//
//					for (int j = 0; j < documentIds.length; j++) {
//
//						DocumentId documentId = documentIds[j];
//
//						if (workspace.getById(documentId) instanceof Category) {
//							Category category = (Category) workspace.getById(documentId);
//							Content catContent = null;
//
//							String catName = category.getName();
//
//							if (!catName.equals("Ministries") && !catName.equals("Authorities") && !catName.equals("Departments") && !catName.equals("Directorates") && !catName.equals("Councils")
//									&& !catName.equals("Corporations") && !catName.equals("Faculties") && !catName.equals("Funds") && !catName.equals("Presidencies") && !catName.equals("Diwans")
//									&& !catName.equals("Other Agencies") && !catName.equals("Universities") && !catName.equals("Governorates") && !catName.equals("Municipalities")) {
//								orgCode = category.getName();
//								dataMap.put("ORG_CODE", orgCode);
//
//							}
//							GovAgencies.put(content.getName(), dataMap);
//
//							// }
//
//						}
//
//					}
//
//					// for(String ke: content.getComponentNames()){
//					// }
//				}
//				i++;
//				if (i == limit) {
//					break;
//				}
//			}
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		Map obj = new HashMap<String, String>();
//		obj.put("Total_Count", docIdIter.getCount() + "");
//		GovAgencies.put("Total_Count", obj);
//
//		return GovAgencies;
//
//	}

	/**
	 * End Government Agencies Directories By Mostafa
	 */

//	public Map<String, String> getGovAgecyInfoTitles(String lang) {
////		start();
//		Map<String, String> info = new HashMap<String, String>();
//		DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//		DocumentIdIterator siteAreaDocumentId = workspace.findAllByPath("Gov. Agencies Directory", DocumentTypes.Site, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//		if (siteAreaDocumentId != null && siteAreaDocumentId.hasNext()) {
//			DocumentId DocumentId = siteAreaDocumentId.nextId();
//
//			try {
//
//				SiteArea siteArea = (SiteArea) workspace.getById(DocumentId);
//				ShortTextComponent parentOrg = (ShortTextComponent) siteArea.getComponent("parentOrganization");
//				info.put("parentOrg", parentOrg.getText());
//				ShortTextComponent city = (ShortTextComponent) siteArea.getComponent("city");
//				info.put("city", city.getText());
//				ShortTextComponent poBox = (ShortTextComponent) siteArea.getComponent("poBox");
//				info.put("poBox", poBox.getText());
//				ShortTextComponent postalCode = (ShortTextComponent) siteArea.getComponent("postalCode");
//				info.put("postalCode", postalCode.getText());
//				ShortTextComponent fax = (ShortTextComponent) siteArea.getComponent("fax");
//				info.put("fax", fax.getText());
//				ShortTextComponent phone = (ShortTextComponent) siteArea.getComponent("phone");
//				info.put("phone", phone.getText());
//				ShortTextComponent email = (ShortTextComponent) siteArea.getComponent("email");
//				info.put("email", email.getText());
//				ShortTextComponent pwebSite = (ShortTextComponent) siteArea.getComponent("webSite");
//				info.put("webSite", pwebSite.getText());
//
//			} catch (Exception e) {
//				System.err.println("****------->>" + e);
//			}
//		}
//
//		return info;
//	}
//
//	/**
//	 * Government Agencies Details By Mostafa
//	 */
//	// Following getorganization() function in this class to get our government
//	// agency details by agency unique name
//	// used in GovBussines
////	public Map<String, String> getAgencyDeatils(String OrganizationId, String lang) {
////		start();
////		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang));
////		DocumentIdIterator docIdIter = workspace.findByName(DocumentTypes.Content, OrganizationId, Workspace.WORKFLOWSTATUS_PUBLISHED);
////		DocumentId wcmDocumentId = null;
////		Map Organization = new HashMap<String, String>();
////		if (docIdIter != null && docIdIter.hasNext()) {
////			wcmDocumentId = docIdIter.nextId();
////			try {
////				Content content = (Content) workspace.getById(wcmDocumentId);
////				Organization.put(IWcmUtils.Key_Description, content.getDescription());
////				Organization.put(IWcmUtils.Key_Name, content.getName());
////				Organization.put(IWcmUtils.Key_Title, content.getTitle());
////				TextComponent MLTranslations = (TextComponent) content.getComponent("ML Translations");
////				Organization.put("ML Translations", MLTranslations.getText());
////
////				LinkComponent parentOrganization = (LinkComponent) content.getComponent("parentOrganization");
////				Organization.put("parentOrganizationURL", parentOrganization.getURL());
////				Organization.put("parentOrganizationLinkText", parentOrganization.getLinkText());
////				LinkComponent webSite = (LinkComponent) content.getComponent("webSite");
////				Organization.put("webSiteURL", webSite.getURL());
////				Organization.put("webSiteLinkText", webSite.getLinkText());
////				ShortTextComponent city = (ShortTextComponent) content.getComponent("city");
////				Organization.put("city", city.getText());
////
////				ShortTextComponent postalCode = (ShortTextComponent) content.getComponent("postalCode");
////				Organization.put("postalCode", postalCode.getText());
////
////				ShortTextComponent poBox = (ShortTextComponent) content.getComponent("poBox");
////				Organization.put("poBox", poBox.getText());
////
////				ShortTextComponent phone = (ShortTextComponent) content.getComponent("phone");
////				Organization.put("phone", phone.getText());
////
////				ShortTextComponent fax = (ShortTextComponent) content.getComponent("fax");
////				Organization.put("fax", fax.getText());
////
////				ShortTextComponent email = (ShortTextComponent) content.getComponent("e-mail");
////				Organization.put("e-mail", email.getText());
////
////				ShortTextComponent workingHours = (ShortTextComponent) content.getComponent("workingHours");
////				Organization.put("workingHours", workingHours.getText());
////
////				ShortTextComponent address = (ShortTextComponent) content.getComponent("address");
////				Organization.put("address", address.getText());
////
////				ShortTextComponent googleMapPointX = (ShortTextComponent) content.getComponent("googleMapPointX");
////				Organization.put("googleMapPointX", googleMapPointX.getText());
////
////				ShortTextComponent googleMapPointY = (ShortTextComponent) content.getComponent("googleMapPointY");
////				Organization.put("googleMapPointY", googleMapPointY.getText());
////
////				ShortTextComponent googleMapZoom = (ShortTextComponent) content.getComponent("googleMapZoom");
////				Organization.put("googleMapZoom", googleMapZoom.getText());
////
////				ImageComponent image = (ImageComponent) content.getComponent("logo");
////				Organization.put("logo", image.getResourceURL());
////			} catch (DocumentRetrievalException e) {
////				e.printStackTrace();
////			} catch (AuthorizationException e) {
////				e.printStackTrace();
////			} catch (ComponentNotFoundException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////
////		}
////		return Organization;
////	}
//
//	/**
//	 * 
//	 * @param agencyTitle
//	 * @param lang
//	 * @return
//	 */
////	public Map<String, String> getAgencyDeatilsByTitle(String agencyTitle, String lang) {
////		start();
////		
////		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT));
////		DocumentId categoryDocId = workspace.findByName(DocumentTypes.Category, "Government Agencies Directory", Workspace.WORKFLOWSTATUS_PUBLISHED).nextId();
////		
////		DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
////		DocumentIdIterator siteAreaDocumentId = workspace.findAllByPath("Gov. Agencies Directory", DocumentTypes.Site, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
////
////		DocumentIdIterator agenciesDocumentId = searchContent(categoryDocId, lang, siteAreaDocumentId, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE,
////				Workspace.SORT_KEY_PUBLISH_DATE);
////		
////		Map Organization = new HashMap<String, String>();
////		DocumentId govagencyDocumentId = null;
////		while (agenciesDocumentId.hasNext()) {
////			govagencyDocumentId = agenciesDocumentId.nextId();
////			Content content = null;
////
////			try {
////				content = (Content) workspace.getById(govagencyDocumentId);
////
////				if (content.getTitle().equals(agencyTitle)) {
////					Organization.put(IWcmUtils.Key_Description, content.getDescription());
////					Organization.put(IWcmUtils.Key_Name, content.getName());
////					Organization.put(IWcmUtils.Key_Title, content.getTitle());
////					TextComponent MLTranslations = (TextComponent) content.getComponent("ML Translations");
////					Organization.put("ML Translations", MLTranslations.getText());
////
////					LinkComponent parentOrganization = (LinkComponent) content.getComponent("parentOrganization");
////					Organization.put("parentOrganizationURL", parentOrganization.getURL());
////					Organization.put("parentOrganizationLinkText", parentOrganization.getLinkText());
////					LinkComponent webSite = (LinkComponent) content.getComponent("webSite");
////					Organization.put("webSiteURL", webSite.getURL());
////					Organization.put("webSiteLinkText", webSite.getLinkText());
////					ShortTextComponent city = (ShortTextComponent) content.getComponent("city");
////					Organization.put("city", city.getText());
////
////					ShortTextComponent postalCode = (ShortTextComponent) content.getComponent("postalCode");
////					Organization.put("postalCode", postalCode.getText());
////
////					ShortTextComponent poBox = (ShortTextComponent) content.getComponent("poBox");
////					Organization.put("poBox", poBox.getText());
////
////					ShortTextComponent phone = (ShortTextComponent) content.getComponent("phone");
////					Organization.put("phone", phone.getText());
////
////					ShortTextComponent fax = (ShortTextComponent) content.getComponent("fax");
////					Organization.put("fax", fax.getText());
////
////					ShortTextComponent email = (ShortTextComponent) content.getComponent("e-mail");
////					Organization.put("e-mail", email.getText());
////
////					ShortTextComponent workingHours = (ShortTextComponent) content.getComponent("workingHours");
////					Organization.put("workingHours", workingHours.getText());
////
////					ShortTextComponent address = (ShortTextComponent) content.getComponent("address");
////					Organization.put("address", address.getText());
////
////					ShortTextComponent googleMapPointX = (ShortTextComponent) content.getComponent("googleMapPointX");
////					Organization.put("googleMapPointX", googleMapPointX.getText());
////
////					ShortTextComponent googleMapPointY = (ShortTextComponent) content.getComponent("googleMapPointY");
////					Organization.put("googleMapPointY", googleMapPointY.getText());
////
////					ShortTextComponent googleMapZoom = (ShortTextComponent) content.getComponent("googleMapZoom");
////					Organization.put("googleMapZoom", googleMapZoom.getText());
////
////					ImageComponent image = (ImageComponent) content.getComponent("logo");
////					Organization.put("logo", image.getResourceURL());
////					break;
////				}
////			} catch (DocumentRetrievalException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			} catch (AuthorizationException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			} catch (ComponentNotFoundException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////
////		}
////
////		return Organization;
////	}
//
////	public Map<String, String> getAllGovAgenciesOrganizations(String lang) {
////		Map organizations = new HashMap<String, String>();
////		DocumentId categoryDocId = getDocumentId(DocumentTypes.Category, "MCIT", IWcmUtils.GovOrganizationTypes);
////		if (lang == null) {
////			lang = "ar";
////		}
////		try {
////			Category contextCategory = (Category) workspace.getById(categoryDocId);
////			DocumentId documentId = null;
////			DocumentIdIterator categoryIterator = contextCategory.getChildren();
////			if (categoryIterator.hasNext()) {
////				while (categoryIterator.hasNext()) {
////					documentId = categoryIterator.nextId();
////					Category category = (Category) workspace.getById(documentId, true);
////					if (category.getName().equalsIgnoreCase("Organizations")) {
////						break;
////					}
////				}
////			}
////			if (documentId != null)
////				organizations = getChildrenCategories(lang, documentId, false);
////
////		} catch (Exception ex) {
////			ex.printStackTrace();
////		}
////		return organizations;
////	}
//
//	// updated @ 5-1-2015 By Mostafa
//	public Map<String, Map<String, String>> getActsAndLaws(String parentCategory, String lang, String cattype, int start, int limit) {
//		Map<String, String> organizationList = getAllGovAgenciesOrganizations(lang);
//		DocumentIdIterator docIdIter = null;
//		if (cattype.equals("topic")) {
//			docIdIter = searchActsandLawsByTopic(parentCategory, lang);
//		} else {
//			if (cattype.equals("Organizations")) {
//				docIdIter = searchActsandLawsByOrganiz(parentCategory, lang);
//			} else {
//				docIdIter = searchActsandLawsByType(parentCategory, lang);
//			}
//
//		}
//
//		DocumentId wcmDocumentId = null;
//		Map ActsAndLaws = new HashMap<String, Map<String, String>>();
//
//		try {
//			int i = 0;
//			limit = start + limit;
//			while (docIdIter != null && docIdIter.hasNext()) {
//				wcmDocumentId = docIdIter.nextId();
//				if (i >= start) {
//					Content content = null;
//					if (workspace.getById(wcmDocumentId) instanceof ContentLink) {
//						ContentLink contentlink = (ContentLink) workspace.getById(wcmDocumentId);
//						content = (Content) workspace.getById(contentlink.getContentId());
//					} else {
//						content = (Content) workspace.getById(wcmDocumentId);
//					}
//
//					Map<String, String> dataMap = new HashMap<String, String>();
//					try {
//						if (!content.getTitle().equalsIgnoreCase("By Topic") && !content.getName().equalsIgnoreCase("byTopic") && !content.getTitle().equalsIgnoreCase("By Organization")
//								&& !content.getName().equalsIgnoreCase("byOrganization")) {// 1-1-2015
//							// By
//							// Mostafa
//
//							if (content.getComponent("actsorbylawsURL") instanceof ShortTextComponent) {
//								ShortTextComponent webSite = (ShortTextComponent) content.getComponent("actsorbylawsURL");
//								dataMap.put("URL", webSite.getText());
//							}
//
//							if (content.getComponent("Type") instanceof OptionSelectionComponent) {
//								OptionSelectionComponent type = (OptionSelectionComponent) content.getComponent("Type");
//								String selectedType = "";
//								for (DocumentId s : type.getCategorySelections()) {
//									selectedType = s.getName();
//									// selectedType = ((Content)
//									// workspace.getById(s)).getTitle();
//									if (lang.equalsIgnoreCase("ar")) {
//										if (workspace.getById(s) instanceof Category) {
//											Category category = (Category) workspace.getById(s);
//											selectedType = category.getTitle();
//										}
//									}
//
//								}
//								dataMap.put("Type", selectedType);
//							}
//
//							if (content.getComponent("By Topic") instanceof OptionSelectionComponent) {
//								OptionSelectionComponent topic = (OptionSelectionComponent) content.getComponent("By Topic");
//								String selectedTopic = "";
//								for (DocumentId s : topic.getCategorySelections()) {
//									selectedTopic = s.getName();
//									// selectedTopic = ((Content)
//									// workspace.getById(s)).getTitle();
//								}
//								dataMap.put("Topic", selectedTopic);
//							}
//							if (content.getComponent("By Organization") instanceof OptionSelectionComponent) {
//								OptionSelectionComponent organization = (OptionSelectionComponent) content.getComponent("By Organization");
//								String selectedOrganization = "";
//								for (DocumentId s : organization.getCategorySelections()) {
//									// selectedOrganization = s.getName();
//
//									// if(lang.equalsIgnoreCase("ar")){
//									// if(workspace.getById(s) instanceof
//									// Category)
//									// {
//									// Category category =(Category)
//									// workspace.getById(s);
//									//
//									// selectedOrganization =
//									// category.getTitle();
//									// }
//									// }
//
//									if (workspace.getById(s) instanceof Category) {
//										Category category = (Category) workspace.getById(s);
//										selectedOrganization = organizationList.get(category.getTitle());
//									}
//
//									// selectedOrganization = ((Content)
//									// workspace.getById(s)).getTitle();
//								}
//								dataMap.put("Organization", selectedOrganization);
//							}
//
//							dataMap.put("Title", content.getTitle());
//							dataMap.put("ResultSize", Integer.toString(docIdIter.getCount()));
//							ActsAndLaws.put(content.getName(), dataMap);
//							i++;
//						}
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//				}
//
//				if (i >= limit) {
//					break;
//				}
//			}
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ActsAndLaws;
//	}
//
//	private DocumentIdIterator searchActsandLawsByTopic(String parentCategory, String lang) {
//		start();
//		DocumentIdIterator docIdIter = null;
//		DocumentId Parent = getDocumentId(DocumentTypes.Category, "MCIT", IWcmUtils.Category_Name_topic);
//		Category contextCategory;
//		try {
//			contextCategory = (Category) workspace.getById(Parent);
//			DocumentIdIterator categoryIterator = contextCategory.getChildren();
//			DocumentId domainDocumentId = null;
//			while (categoryIterator.hasNext()) {
//				domainDocumentId = categoryIterator.nextId();
//				if (workspace.getPathById(domainDocumentId, true, true).equals(IWcmUtils.ActandLawsCatTopicPath + parentCategory)) {
//					break;
//				}
//			}
//			docIdIter = searchContent(domainDocumentId, lang, IWcmUtils.ActsAndLaws_SITE_AREA, null, null, null);
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			e.printStackTrace();
//		} catch (IllegalDocumentTypeException e) {
//			e.printStackTrace();
//		}
//		return docIdIter;
//	}
//
//	private DocumentIdIterator searchActsandLawsByOrganiz(String parentCategory, String lang) {
//		start();
//		DocumentIdIterator docIdIter = null;
//		DocumentId Parent = getDocumentId(DocumentTypes.Category, "MCIT", IWcmUtils.AllGovAgencies);
//		Category contextCategory;
//		try {
//			contextCategory = (Category) workspace.getById(Parent);
//			DocumentIdIterator categoryIterator = contextCategory.getChildren();
//			DocumentId domainDocumentId = null;
//
//			while (categoryIterator.hasNext()) {
//				domainDocumentId = categoryIterator.nextId();
//				// if (workspace.getPathById(domainDocumentId, true,
//				// true).equals(IWcmUtils.Organizations_Pathy_ByMCIT +
//				// parentCategory)) {
//				if (((Category) workspace.getById(domainDocumentId)).getTitle().equalsIgnoreCase(parentCategory)) {
//					break;
//				}
//			}
//			/***
//			 * By Mostafa @ 1-1-2015
//			 */
//			DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//			DocumentIdIterator siteAreaDocumentId = workspace.findAllByPath("Acts and Bylaws", DocumentTypes.Site, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//
//			docIdIter = searchContent(domainDocumentId, lang, siteAreaDocumentId, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE);
//			// End edit 1-1-2015
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			e.printStackTrace();
//		}
//		return docIdIter;
//	}
//
//	private DocumentIdIterator searchActsandLawsByType(String parentCategory, String lang) {
//		start();
//		DocumentIdIterator docIdIter = null;
//		DocumentId Parent = getDocumentId(DocumentTypes.Category, "MCIT", IWcmUtils.Category_Name_type);
//
//		Category contextCategory;
//		try {
//			contextCategory = (Category) workspace.getById(Parent);
//
//			DocumentIdIterator categoryIterator = contextCategory.getChildren();
//
//			DocumentId domainDocumentId = null;
//			while (categoryIterator.hasNext()) {
//				domainDocumentId = categoryIterator.nextId();
//				if (workspace.getPathById(domainDocumentId, true, true).equals(IWcmUtils.ActandLawsCatTypePath + parentCategory)) {
//					break;
//				}
//			}
//			docIdIter = searchContent(domainDocumentId, lang, IWcmUtils.ActsAndLaws_SITE_AREA, null, null, null);
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			e.printStackTrace();
//		} catch (IllegalDocumentTypeException e) {
//			e.printStackTrace();
//		}
//		return docIdIter;
//	}
//
//	public Map<String, String> getProjectIntiativetype(String lang) {
//		start();
//		return getCategories(IWcmUtils.NationPlans_Developement_Types, lang, false, false);
//	}
//
//	public Map<String, Map<String, String>> getNationPlansAndInitiaitives(String parentCategory, String lang, int start, int limit) {
//		Map<String, Map<String, String>> dataMap = new HashMap<String, Map<String, String>>();
//		DocumentIdIterator docIdIter = searchNationPalnsAndInitiativesContent(parentCategory, lang);
//		DocumentId wcmDocumentId = null;
//		try {
//			int i = 0;
//			limit = start + limit;
//			while (docIdIter != null && docIdIter.hasNext()) {
//				wcmDocumentId = docIdIter.nextId();
//				if (i >= start) {
//					Content content = null;
//					if (workspace.getById(wcmDocumentId) instanceof ContentLink) {
//						ContentLink contentlink = (ContentLink) workspace.getById(wcmDocumentId);
//						content = (Content) workspace.getById(contentlink.getContentId());
//					} else {
//						content = (Content) workspace.getById(wcmDocumentId);
//					}
//
//					if (content.getName().equalsIgnoreCase("Initiatives") || content.getName().equalsIgnoreCase("NationalPlans")) {
//						continue;
//					}
//					Map<String, String> bufferMap = new HashMap<String, String>();
//					bufferMap.put("Title", content.getTitle());
//
//					if (content.getComponent("NationalPlansandInitiatives") instanceof OptionSelectionComponent) {
//						OptionSelectionComponent type = (OptionSelectionComponent) content.getComponent("NationalPlansandInitiatives");
//						String selectedType = "";
//						for (DocumentId s : type.getCategorySelections()) {
//							selectedType = s.getName();
//
//							if (lang.equalsIgnoreCase("ar")) {
//								if (workspace.getById(s) instanceof Category) {
//									Category category = (Category) workspace.getById(s);
//									selectedType = category.getTitle();
//								}
//							}
//
//						}
//						bufferMap.put("Type", selectedType);
//					}
//					// try {
//					// RichTextComponent rich =
//					// (RichTextComponent)content.getComponent("mainContent");
//					// bufferMap.put("BrifeDesc",
//					// rich.getRichText().substring(200));
//					// System.out.println("RichText: "+rich.getRichText());
//					// System.out.println("BrifeDesc: "+rich.getRichText().substring(200));
//					//
//					// } catch (ComponentNotFoundException e) {
//					// // TODO Auto-generated catch block
//					// bufferMap.put("BrifeDesc", "");
//					// e.printStackTrace();
//					// }
//
//					bufferMap.put("Map_Counts", String.valueOf(docIdIter.getCount()));
//					dataMap.put(content.getName(), bufferMap);
//				}
//
//				i++;
//				if (i == limit) {
//					break;
//				}
//			}
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			e.printStackTrace();
//		} catch (ComponentNotFoundException e) {
//			e.printStackTrace();
//		} catch (OperationFailedException e) {
//			e.printStackTrace();
//		}
//
//		return dataMap;
//
//	}
//
//	public Map<String, String> getNationPlanAndInitiaitiveDetails(String docmentName, String lang) {
//
//		Map<String, String> dataMap = new HashMap<String, String>();
//
//		try {
//			workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang));
//			DocumentIdIterator docIdIter = workspace.findByName(DocumentTypes.Content, docmentName, Workspace.WORKFLOWSTATUS_PUBLISHED);
//			DocumentId wcmDocumentId = null;
//			Content content = null;
//			while (docIdIter != null && docIdIter.hasNext()) {
//				wcmDocumentId = docIdIter.nextId();
//				content = (Content) workspace.getById(wcmDocumentId);
//			}
//			dataMap.put("Name", content.getName());
//			dataMap.put("Title", content.getTitle());
//			// 31-12-2014 By Mostafa sayed ***Start
//			if (docmentName.equalsIgnoreCase("Development Projects")) {
//				if (content.getComponent("StaticContent") instanceof RichTextComponent) {
//					RichTextComponent descriptionComp = (RichTextComponent) content.getComponent("StaticContent");
//					String descTxt = descriptionComp.getRichText();
//
//					dataMap.put("Description", descTxt);
//				}
//			} else {
//				if (content.getComponent("mainContent") instanceof RichTextComponent) {
//					RichTextComponent descriptionComp = (RichTextComponent) content.getComponent("mainContent");
//					String descTxt = descriptionComp.getRichText();
//
//					dataMap.put("Description", descTxt);
//				}
//			}
//			// 31-12-2014 By Mostafa sayed ***End
//
//		} catch (ComponentNotFoundException e) {
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		return dataMap;
//	}
//
//	// **Start Search by keyword in NationPlansAndDevelopement @ 17-1-2015
//	public Map<String, Map<String, String>> searchNationPlansAndDevelopementByKeyword(String lang, String keyword, int limit) {
//
//		int i = 0;
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT));//
//
//		DocumentId categoryDocId = workspace.findByName(DocumentTypes.Category, IWcmUtils.NationPlans_Developement_Types, Workspace.WORKFLOWSTATUS_PUBLISHED).nextId();
//		Map<String, Map<String, String>> dataMap = new HashMap<String, Map<String, String>>();
//		try {
//			keyword = keyword.toLowerCase();
//			DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//			DocumentIdIterator siteAreaDocumentId = workspace.findAllByPath(IWcmUtils.NationPlansAndDevelopement_SITE_AREA, DocumentTypes.Site, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//
//			DocumentIdIterator newsListDocumentId = searchContent(categoryDocId, lang, siteAreaDocumentId, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE,
//					Workspace.SORT_KEY_PUBLISH_DATE);
//			DocumentId newsDocumentId = null;
//
//			while (newsListDocumentId.hasNext()) {
//				newsDocumentId = newsListDocumentId.nextId();
//				Content content = null;
//				content = (Content) workspace.getById(newsDocumentId);
//				if (content.getName().equalsIgnoreCase("Initiatives") || content.getName().equalsIgnoreCase("NationalPlans")) {
//					continue;
//				}
//				boolean[] found = new boolean[3];
//				try {
//					found[0] = (content.getTitle().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[0] = false;
//				}
//				try {
//					found[1] = (content.getDescription().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[1] = false;
//				}
//				try {
//					RichTextComponent rich = (RichTextComponent) content.getComponent("mainContent");
//					found[2] = (rich.getRichText().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[2] = false;
//				}
//				if (found[0] || found[1] || found[2]) {
//					Map<String, String> bufferMap = new HashMap<String, String>();
//					bufferMap.put("Title", content.getTitle());
//
//					if (content.getComponent("NationalPlansandInitiatives") instanceof OptionSelectionComponent) {
//						OptionSelectionComponent type = (OptionSelectionComponent) content.getComponent("NationalPlansandInitiatives");
//						String selectedType = "";
//						for (DocumentId s : type.getCategorySelections()) {
//							selectedType = s.getName();
//
//							if (lang.equalsIgnoreCase("ar")) {
//								if (workspace.getById(s) instanceof Category) {
//									Category category = (Category) workspace.getById(s);
//									selectedType = category.getTitle();
//								}
//							}
//
//						}
//						bufferMap.put("Type", selectedType);
//					}
//					// RichTextComponent rich;
//					// try {
//					// rich =
//					// (RichTextComponent)content.getComponent("mainContent");
//					// if(rich.getRichText().length()< 200){
//					// bufferMap.put("BrifeDesc", rich.getRichText());
//					// }else{
//					// bufferMap.put("BrifeDesc",
//					// rich.getRichText().substring(200));
//					// }
//					//
//					// } catch (ComponentNotFoundException e) {
//					// // TODO Auto-generated catch block
//					// bufferMap.put("BrifeDesc", "");
//					// e.printStackTrace();
//					// }
//					dataMap.put(content.getName(), bufferMap);
//
//					i++;
//
//				}
//
//				if (dataMap.size() > (limit - 1) || i > (limit - 1)) {
//					break;
//				}
//			}
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ComponentNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (OperationFailedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return dataMap;
//
//	}
//
//	// /**End search by keyword in NationPlansAndDevelopement @ 17-1-2015
//
//	// //////////*******************************///////////////
//	public Map<String, Map<String, String>> searchNationPlansAndDevelopementByAll(String lang, String keyword, String[] types) {
//
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT));//
//
//		DocumentId categoryDocId = workspace.findByName(DocumentTypes.Category, IWcmUtils.NationPlans_Developement_Types, Workspace.WORKFLOWSTATUS_PUBLISHED).nextId();
//		Map<String, Map<String, String>> dataMap = new HashMap<String, Map<String, String>>();
//		try {
//
//			DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//			DocumentIdIterator siteAreaDocumentId = workspace.findAllByPath(IWcmUtils.NationPlansAndDevelopement_SITE_AREA, DocumentTypes.Site, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//
//			DocumentIdIterator newsListDocumentId = searchContent(categoryDocId, lang, siteAreaDocumentId, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE,
//					Workspace.SORT_KEY_PUBLISH_DATE);
//			DocumentId newsDocumentId = null;
//
//			while (newsListDocumentId.hasNext()) {
//				newsDocumentId = newsListDocumentId.nextId();
//				Content content = null;
//				content = (Content) workspace.getById(newsDocumentId);
//				// if(content.getName().equalsIgnoreCase("Initiatives") ||
//				// content.getName().equalsIgnoreCase("NationalPlans")){
//				// continue ;
//				// }
//				boolean[] found = new boolean[4];
//				String selectedType = "";
//
//				if (keyword == null || keyword.equals("")) {
//					found[0] = true;
//				} else {
//					keyword = keyword.toLowerCase();
//					try {
//						found[0] = (content.getTitle().toLowerCase()).contains(keyword);
//					} catch (Exception e) {
//						found[0] = false;
//					}
//					try {
//						found[1] = (content.getDescription().toLowerCase()).contains(keyword);
//					} catch (Exception e) {
//						found[1] = false;
//					}
//					try {
//						RichTextComponent rich = (RichTextComponent) content.getComponent("mainContent");
//						found[2] = (rich.getRichText().toLowerCase()).contains(keyword);
//					} catch (Exception e) {
//						found[2] = false;
//					}
//
//				}
//				try {
//					OptionSelectionComponent type = (OptionSelectionComponent) content.getComponent("NationalPlansandInitiatives");
//
//					for (DocumentId s : type.getCategorySelections()) {
//						selectedType = s.getName();
//						if (types == null) {
//							found[3] = true;
//						} else {
//							for (String newtype : types) {
//								found[3] = newtype.equalsIgnoreCase(s.getName());
//								if (found[3]) {
//									break;
//								}
//							}
//						}
//
//						if (lang.equalsIgnoreCase("ar")) {
//							if (workspace.getById(s) instanceof Category) {
//								Category category = (Category) workspace.getById(s);
//								selectedType = category.getTitle();
//							}
//						}
//
//					}
//
//				} catch (Exception e) {
//					found[3] = false;
//				}
//
//				if ((found[0] || found[1] || found[2]) && found[3]) {
//					Map<String, String> bufferMap = new HashMap<String, String>();
//					bufferMap.put("Title", content.getTitle());
//					bufferMap.put("Type", selectedType);
//
//					// RichTextComponent rich;
//					// try {
//					// rich =
//					// (RichTextComponent)content.getComponent("mainContent");
//					// if(rich.getRichText().length()< 200){
//					// bufferMap.put("BrifeDesc", rich.getRichText());
//					// }else{
//					// bufferMap.put("BrifeDesc",
//					// rich.getRichText().substring(200));
//					// }
//					//
//					// } catch (ComponentNotFoundException e) {
//					// // TODO Auto-generated catch block
//					// bufferMap.put("BrifeDesc", "");
//					// e.printStackTrace();
//					// }
//					dataMap.put(content.getName(), bufferMap);
//
//				}
//
//			}
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return dataMap;
//
//	}
//
//	// //////////////////////////********************///////////////
//
//	private DocumentIdIterator searchNationPalnsAndInitiativesContent(String parentCategory, String lang) {
//		start();
//		DocumentIdIterator docIdIter = null;
//		DocumentId Parent = getDocumentId(DocumentTypes.Category, "MCIT", IWcmUtils.NationPlans_DevelopementTypes);
//		Category contextCategory;
//		try {
//			contextCategory = (Category) workspace.getById(Parent);
//			DocumentIdIterator categoryIterator = contextCategory.getChildren();
//			DocumentId domainDocumentId = null;
//			while (categoryIterator.hasNext()) {
//				domainDocumentId = categoryIterator.nextId();
//				if (workspace.getPathById(domainDocumentId, true, true).equals(IWcmUtils.NationPlansAndDevelopement_Path + parentCategory)) {
//					break;
//				}
//			}
//			// //////bhdsdgjh
//
//			docIdIter = searchContent(domainDocumentId, lang, IWcmUtils.NationPlansAndDevelopement_SITE_AREA, null, null, null);
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			e.printStackTrace();
//		} catch (IllegalDocumentTypeException e) {
//			e.printStackTrace();
//		}
//		return docIdIter;
//	}
//
//	// SEARCH BY KEYWORD IN ACTS AND LAWS MOSTAFA & LILIAN @ 5-1-2015
//
//	public List searchActsAndLawsByKeyword(String lang, String keyword, int limit) {
//		Map<String, String> organizationList = getAllGovAgenciesOrganizations(lang);
//		// search by keyword in ByTopic
//		int i = 0;
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT));// //By
//		// Topic
//		// Organizations
//		// types
//		//
//		DocumentId categoryDocId = workspace.findByName(DocumentTypes.Category, "By Topic", Workspace.WORKFLOWSTATUS_PUBLISHED).nextId();
//		List actsAndLawsList = new ArrayList<ArrayList<String>>();
//		try {
//			keyword = keyword.toLowerCase();
//			DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//			DocumentIdIterator siteAreaDocumentId = workspace.findAllByPath("Acts and Bylaws", DocumentTypes.Site, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//
//			DocumentIdIterator newsListDocumentId = searchContent(categoryDocId, lang, siteAreaDocumentId, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE,
//					Workspace.SORT_KEY_PUBLISH_DATE);
//			DocumentId newsDocumentId = null;
//
//			while (newsListDocumentId.hasNext()) {
//				newsDocumentId = newsListDocumentId.nextId();
//				Content content = null;
//				content = (Content) workspace.getById(newsDocumentId);
//				boolean[] found = new boolean[3];
//				try {
//					found[0] = (content.getTitle().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[0] = false;
//				}
//				try {
//					found[1] = (content.getDescription().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[1] = false;
//				}
//				try {
//					RichTextComponent body = (RichTextComponent) content.getComponent(IWcmUtils.Component_Name_body);
//					found[2] = (body.getRichText().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[2] = false;
//				}
//				if (found[0] || found[1] || found[2]) {
//
//					if (!content.getTitle().equalsIgnoreCase("By Topic") && !content.getName().equalsIgnoreCase("byTopic") && !content.getTitle().equalsIgnoreCase("By Organization")
//							&& !content.getName().equalsIgnoreCase("byOrganization")) {// 1-1-2015
//						// By
//						// Mostafa
//						ArrayList<String> contentvalue = new ArrayList<String>();
//						contentvalue.add(content.getName());// 0
//						contentvalue.add(content.getTitle());// 1
//						contentvalue.add(content.getDescription());// 2
//
//						try {
//							if (content.getComponent("actsorbylawsURL") instanceof ShortTextComponent) {
//								ShortTextComponent webSite = (ShortTextComponent) content.getComponent("actsorbylawsURL");
//								contentvalue.add(webSite.getText());// 3
//
//							}
//						} catch (ComponentNotFoundException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//
//						try {
//							if (content.getComponent("Type") instanceof OptionSelectionComponent) {
//								OptionSelectionComponent type = (OptionSelectionComponent) content.getComponent("Type");
//								String selectedType = "";
//								for (DocumentId s : type.getCategorySelections()) {
//									selectedType = s.getName();
//									// selectedType = ((Content)
//									// workspace.getById(s)).getTitle();
//									if (lang.equalsIgnoreCase("ar")) {
//										if (workspace.getById(s) instanceof Category) {
//											Category category = (Category) workspace.getById(s);
//											selectedType = category.getTitle();
//										}
//									}
//
//								}
//								contentvalue.add(selectedType);// 4
//							}
//						} catch (ComponentNotFoundException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						} catch (OperationFailedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//
//						try {
//							if (content.getComponent("By Topic") instanceof OptionSelectionComponent) {
//								OptionSelectionComponent topic = (OptionSelectionComponent) content.getComponent("By Topic");
//								String selectedTopic = "";
//								for (DocumentId s : topic.getCategorySelections()) {
//									selectedTopic = s.getName();
//
//								}
//								contentvalue.add(selectedTopic);// 5
//							}
//						} catch (ComponentNotFoundException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						} catch (OperationFailedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//
//						try {
//
//							if (content.getComponent("By Organization") instanceof OptionSelectionComponent) {
//								OptionSelectionComponent organization = (OptionSelectionComponent) content.getComponent("By Organization");
//								String selectedOrganization = "";
//								for (DocumentId s : organization.getCategorySelections()) {
//
//									if (workspace.getById(s) instanceof Category) {
//										Category category = (Category) workspace.getById(s);
//										selectedOrganization = organizationList.get(category.getTitle());
//									}
//
//									// selectedOrganization = ((Content)
//									// workspace.getById(s)).getTitle();
//								}
//								contentvalue.add(selectedOrganization);
//							}
//
//							// if (content.getComponent("By Organization")
//							// instanceof OptionSelectionComponent) {
//							// OptionSelectionComponent organization =
//							// (OptionSelectionComponent)
//							// content.getComponent("By Organization");
//							// String selectedOrganization = "";
//							// for (DocumentId s :
//							// organization.getCategorySelections()) {
//							// selectedOrganization = s.getName();
//							// if (lang.equalsIgnoreCase("ar")) {
//							// if (workspace.getById(s) instanceof Category) {
//							// Category category = (Category)
//							// workspace.getById(s);
//							// selectedOrganization = category.getTitle();
//							// }
//							// }
//							// // selectedOrganization = ((Content)
//							// // workspace.getById(s)).getTitle();
//							// }
//							// contentvalue.add(selectedOrganization);// 6
//							// }
//						} catch (ComponentNotFoundException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						} catch (OperationFailedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//
//						actsAndLawsList.add(contentvalue);
//						i++;
//					}
//
//				}
//				if (actsAndLawsList.size() > (limit - 1) || i > (limit - 1)) {
//					break;
//				}
//			}
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// catch (ComponentNotFoundException e) {
//		// // TODO Auto-generated catch block
//		// e.printStackTrace();
//		// }
//
//		// search by keyword in Organizations
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT));// //By
//		// Topic
//		// Organizations
//		// types
//		categoryDocId = workspace.findByName(DocumentTypes.Category, "Organizations", Workspace.WORKFLOWSTATUS_PUBLISHED).nextId();
//		if (actsAndLawsList == null || actsAndLawsList.isEmpty()) {
//			actsAndLawsList = new ArrayList<ArrayList<String>>();
//		}
//
//		try {
//			keyword = keyword.toLowerCase();
//			DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//			DocumentIdIterator siteAreaDocumentId = workspace.findAllByPath("Acts and Bylaws", DocumentTypes.Site, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//
//			DocumentIdIterator newsListDocumentId = searchContent(categoryDocId, lang, siteAreaDocumentId, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE,
//					Workspace.SORT_KEY_PUBLISH_DATE);
//			DocumentId newsDocumentId = null;
//
//			while (newsListDocumentId.hasNext()) {
//				if (actsAndLawsList.size() > (limit - 1) || i > (limit - 1)) {
//					break;
//				}
//				newsDocumentId = newsListDocumentId.nextId();
//				Content content = null;
//				content = (Content) workspace.getById(newsDocumentId);
//				boolean[] found = new boolean[3];
//				try {
//					found[0] = (content.getTitle().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[0] = false;
//				}
//				try {
//					found[1] = (content.getDescription().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[1] = false;
//				}
//				try {
//					RichTextComponent body = (RichTextComponent) content.getComponent(IWcmUtils.Component_Name_body);
//					found[2] = (body.getRichText().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[2] = false;
//				}
//				if (found[0] || found[1] || found[2]) {
//					ArrayList<String> contentvalue = new ArrayList<String>();
//					contentvalue.add(content.getName());
//					contentvalue.add(content.getTitle());
//					contentvalue.add(content.getDescription());
//					if (!content.getTitle().equalsIgnoreCase("By Topic") && !content.getName().equalsIgnoreCase("byTopic") && !content.getTitle().equalsIgnoreCase("By Organization")
//							&& !content.getName().equalsIgnoreCase("byOrganization")) {// 1-1-2015
//						// By
//						// Mostafa
//
//						try {
//							if (content.getComponent("actsorbylawsURL") instanceof ShortTextComponent) {
//								ShortTextComponent webSite = (ShortTextComponent) content.getComponent("actsorbylawsURL");
//								contentvalue.add(webSite.getText());
//
//							}
//						} catch (ComponentNotFoundException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//
//						try {
//							if (content.getComponent("Type") instanceof OptionSelectionComponent) {
//								OptionSelectionComponent type = (OptionSelectionComponent) content.getComponent("Type");
//								String selectedType = "";
//								for (DocumentId s : type.getCategorySelections()) {
//									selectedType = s.getName();
//									// selectedType = ((Content)
//									// workspace.getById(s)).getTitle();
//									if (lang.equalsIgnoreCase("ar")) {
//										if (workspace.getById(s) instanceof Category) {
//											Category category = (Category) workspace.getById(s);
//											selectedType = category.getTitle();
//										}
//									}
//
//								}
//								contentvalue.add(selectedType);
//							}
//						} catch (ComponentNotFoundException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						} catch (OperationFailedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//
//						try {
//							if (content.getComponent("By Topic") instanceof OptionSelectionComponent) {
//								OptionSelectionComponent topic = (OptionSelectionComponent) content.getComponent("By Topic");
//								String selectedTopic = "";
//								for (DocumentId s : topic.getCategorySelections()) {
//									selectedTopic = s.getName();
//									// selectedTopic = ((Content)
//									// workspace.getById(s)).getTitle();
//								}
//								contentvalue.add(selectedTopic);
//							}
//						} catch (ComponentNotFoundException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						} catch (OperationFailedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//
//						try {
//							if (content.getComponent("By Organization") instanceof OptionSelectionComponent) {
//								OptionSelectionComponent organization = (OptionSelectionComponent) content.getComponent("By Organization");
//								String selectedOrganization = "";
//								for (DocumentId s : organization.getCategorySelections()) {
//									selectedOrganization = s.getName();
//									if (lang.equalsIgnoreCase("ar")) {
//										if (workspace.getById(s) instanceof Category) {
//											Category category = (Category) workspace.getById(s);
//											selectedOrganization = category.getTitle();
//										}
//									}
//									// selectedOrganization = ((Content)
//									// workspace.getById(s)).getTitle();
//								}
//								contentvalue.add(selectedOrganization);
//							}
//						} catch (ComponentNotFoundException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						} catch (OperationFailedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//
//						// contentvalue.add(Integer.toString(newsListDocumentId.getCount()-2));//7
//						actsAndLawsList.add(contentvalue);
//						i++;
//					}
//
//				}
//
//			}
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return actsAndLawsList;
//
//	}
//
//	// ENDSEARCH BY KEYWORD IN ACTS AND LAWS
//
//	// Start Open Gov Data Functions
//
//	public Map<String, String> getOpenGovDataTypes(String lang) {
//		start();
//		return getCategories(IWcmUtils.OpenGovData, lang, false, false);
//	}
//
//	private DocumentIdIterator searchOpenGovDataByType(String parentCategory, String lang) {
//		start();
//		DocumentIdIterator docIdIter = null;
//		DocumentId Parent = getDocumentId(DocumentTypes.Category, "MCIT", IWcmUtils.OpenGovData);
//
//		Category contextCategory;
//		try {
//			contextCategory = (Category) workspace.getById(Parent);
//
//			DocumentIdIterator categoryIterator = contextCategory.getChildren();
//
//			DocumentId domainDocumentId = null;
//			while (categoryIterator.hasNext()) {
//				domainDocumentId = categoryIterator.nextId();
//				if (workspace.getPathById(domainDocumentId, true, true).equals(IWcmUtils.OpenGovDataTypes_Path + parentCategory)) {
//					break;
//				}
//			}
//			docIdIter = searchContent(domainDocumentId, lang, IWcmUtils.OpenGovData, null, null, null);
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			e.printStackTrace();
//		} catch (IllegalDocumentTypeException e) {
//			e.printStackTrace();
//		}
//		return docIdIter;
//	}
//
//	public Map<String, Map<String, String>> getOpenGovData(String parentCategory, String lang, int start, int limit) {
//		DocumentIdIterator docIdIter = null;
//		docIdIter = searchOpenGovDataByType(parentCategory, lang);
//
//		DocumentId wcmDocumentId = null;
//		Map ActsAndLaws = new HashMap<String, Map<String, String>>();
//
//		try {
//			int i = 0;
//			limit = start + limit;
//			while (docIdIter != null && docIdIter.hasNext()) {
//				wcmDocumentId = docIdIter.nextId();
//				if (i >= start) {
//					Content content = null;
//					if (workspace.getById(wcmDocumentId) instanceof ContentLink) {
//						ContentLink contentlink = (ContentLink) workspace.getById(wcmDocumentId);
//						content = (Content) workspace.getById(contentlink.getContentId());
//					} else {
//						content = (Content) workspace.getById(wcmDocumentId);
//					}
//
//					Map<String, String> dataMap = new HashMap<String, String>();
//					try {
//
//						// content.getComponent("lnk_DocumentParentOrganization")
//						// **** LinkComponent
//						// content.getComponent("ML Translations") ****
//						// TextComponent
//						// content.getComponent("txt_DocumentFileName")****
//						// LinkComponent
//
//						if (content.getComponent("lnk_DocumentParentOrganization") instanceof LinkComponent) {
//							LinkComponent parentOrg_Link = (LinkComponent) content.getComponent("lnk_DocumentParentOrganization");
//
//							DocumentId parentOrg_docID = parentOrg_Link.getDocumentReference();
//							Content category = (Content) workspace.getById(parentOrg_docID, true);
//							dataMap.put("parentOrg", category.getTitle());
//
//						}
//						if (content.getComponent("txt_DocumentFileName") instanceof LinkComponent) {
//							LinkComponent docFile_Link = (LinkComponent) content.getComponent("txt_DocumentFileName");
//							dataMap.put("ExcelFile", docFile_Link.getURL());
//						}
//
//						dataMap.put("Title", content.getTitle());
//						dataMap.put("ResultSize", Integer.toString(docIdIter.getCount()));
//
//						Calendar c = Calendar.getInstance();
//						c.setTime(content.getPublishedDate());
//						dataMap.put("publishYear", c.get(Calendar.YEAR) + "");
//
//						ActsAndLaws.put(content.getName(), dataMap);
//						i++;
//
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//				}
//
//				if (i >= limit) {
//					break;
//				}
//			}
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ActsAndLaws;
//	}
//
//	// START SEARCH BY KEYWORD IN OPEN GOV DATA
//
//	public Map<String, Map<String, String>> searchopenGovDataByKeyword(String lang, String keyword, int limit) {
//		// search by keyword in ByTopic
//		int i = 0;
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT));//
//		// types
//		//
//		DocumentId categoryDocId = workspace.findByName(DocumentTypes.Category, IWcmUtils.OpenGovData, Workspace.WORKFLOWSTATUS_PUBLISHED).nextId();
//		Map openGovDataMap = new HashMap<String, Map<String, String>>();
//		try {
//			keyword = keyword.toLowerCase();
//			DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//			DocumentIdIterator siteAreaDocumentId = workspace.findAllByPath(IWcmUtils.OpenGovData, DocumentTypes.Site, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//
//			DocumentIdIterator newsListDocumentId = searchContent(categoryDocId, lang, siteAreaDocumentId, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE,
//					Workspace.SORT_KEY_PUBLISH_DATE);
//			DocumentId newsDocumentId = null;
//
//			while (newsListDocumentId.hasNext()) {
//				newsDocumentId = newsListDocumentId.nextId();
//				Content content = null;
//				content = (Content) workspace.getById(newsDocumentId);
//				boolean[] found = new boolean[3];
//				try {
//					found[0] = (content.getTitle().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[0] = false;
//				}
//				try {
//					found[1] = (content.getDescription().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[1] = false;
//				}
//				try {
//					RichTextComponent body = (RichTextComponent) content.getComponent(IWcmUtils.Component_Name_body);
//					found[2] = (body.getRichText().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[2] = false;
//				}
//				if (found[0] || found[1] || found[2]) {
//
//					Map<String, String> dataMap = new HashMap<String, String>();
//					try {
//
//						if (content.getComponent("lnk_DocumentParentOrganization") instanceof LinkComponent) {
//							LinkComponent parentOrg_Link = (LinkComponent) content.getComponent("lnk_DocumentParentOrganization");
//
//							DocumentId parentOrg_docID = parentOrg_Link.getDocumentReference();
//							Content category = (Content) workspace.getById(parentOrg_docID, true);
//							if (lang.equalsIgnoreCase("ar")) {
//								dataMap.put("parentOrg", category.getTitle());
//							} else {
//								dataMap.put("parentOrg", category.getName());
//							}
//
//						}
//						if (content.getComponent("txt_DocumentFileName") instanceof LinkComponent) {
//							LinkComponent docFile_Link = (LinkComponent) content.getComponent("txt_DocumentFileName");
//							dataMap.put("ExcelFile", docFile_Link.getURL());
//						}
//
//						dataMap.put("Title", content.getTitle());
//						try {
//							Calendar c = Calendar.getInstance();
//							c.setTime(content.getPublishedDate());
//							dataMap.put("publishYear", c.get(Calendar.YEAR) + "");
//
//						} catch (Exception ex) {
//							dataMap.put("publishYear", "1999");
//						}
//
//						openGovDataMap.put(content.getName(), dataMap);
//						i++;
//
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//				}
//				if (openGovDataMap.size() > (limit - 1) || i > (limit - 1)) {
//					break;
//				}
//			}
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return openGovDataMap;
//
//	}
//
//	// END SEARCH BY KEYWORD IN OPEN GOV DATA
//	/**
//		 * 
//		 */
//	public Map<String, String> getYearsOfOpenGov(String lang) {
//
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT));//
//		DocumentId categoryDocId = workspace.findByName(DocumentTypes.Category, IWcmUtils.OpenGovData, Workspace.WORKFLOWSTATUS_PUBLISHED).nextId();
//		Map<String, String> years = new HashMap<String, String>();
//		try {
//
//			DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//			DocumentIdIterator siteAreaDocumentId = workspace.findAllByPath(IWcmUtils.OpenGovData, DocumentTypes.Site, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//
//			DocumentIdIterator newsListDocumentId = searchContent(categoryDocId, lang, siteAreaDocumentId, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE,
//					Workspace.SORT_KEY_PUBLISH_DATE);
//			DocumentId newsDocumentId = null;
//
//			while (newsListDocumentId.hasNext()) {
//				newsDocumentId = newsListDocumentId.nextId();
//				Content content = null;
//				content = (Content) workspace.getById(newsDocumentId);
//
//				try {
//					Calendar c = Calendar.getInstance();
//					c.setTime(content.getPublishedDate());
//					years.put(String.valueOf(c.get(Calendar.YEAR)), String.valueOf(c.get(Calendar.YEAR)));
//
//				} catch (Exception e) {
//
//				}
//
//			}
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		System.out.println("YEARSSSSSSSS: " + years.size());
//		for (String y : years.keySet()) {
//			System.out.println("**--->>>" + years.get(y));
//		}
//
//		return years;
//
//	}
//
//	// //****End Get Years of open Gov Data
//
//	// ********* Search in OPEN GOV DATA by ALL Filters
//	public Map<String, Map<String, String>> searchopenGovDataByAll(String lang, String keyword, String[] years, String[] sites) {
//		// search by keyword in ByTopic
//
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT));//
//		// types
//		//
//		DocumentId categoryDocId = workspace.findByName(DocumentTypes.Category, IWcmUtils.OpenGovData, Workspace.WORKFLOWSTATUS_PUBLISHED).nextId();
//		Map openGovDataMap = new HashMap<String, Map<String, String>>();
//		try {
//
//			DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//
//			DocumentIdIterator siteAreaDocumentId = workspace.findAllByPath(IWcmUtils.OpenGovData, DocumentTypes.Site, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//
//			DocumentIdIterator newsListDocumentId = searchContent(categoryDocId, lang, siteAreaDocumentId, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE,
//					Workspace.SORT_KEY_PUBLISH_DATE);
//			DocumentId newsDocumentId = null;
//
//			while (newsListDocumentId.hasNext()) {
//				newsDocumentId = newsListDocumentId.nextId();
//				Content content = null;
//				content = (Content) workspace.getById(newsDocumentId);
//				boolean[] found = new boolean[5];
//				if (keyword == null) {
//					found[0] = true;
//				} else {
//					keyword = keyword.toLowerCase();
//					try {
//						found[0] = (content.getTitle().toLowerCase()).contains(keyword);
//					} catch (Exception e) {
//						found[0] = false;
//					}
//					try {
//						found[1] = (content.getDescription().toLowerCase()).contains(keyword);
//					} catch (Exception e) {
//						found[1] = false;
//					}
//					try {
//						RichTextComponent body = (RichTextComponent) content.getComponent(IWcmUtils.Component_Name_body);
//						found[2] = (body.getRichText().toLowerCase()).contains(keyword);
//					} catch (Exception e) {
//						found[2] = false;
//					}
//				}
//				try {
//					if (years == null) {
//						found[3] = true;
//					} else {
//						for (String year : years) {
//							Calendar c = Calendar.getInstance();
//							c.setTime(content.getPublishedDate());
//							found[3] = year.equalsIgnoreCase(String.valueOf(c.get(Calendar.YEAR)));
//							if (found[3])
//								break;
//						}
//					}
//
//				} catch (Exception e) {
//					found[3] = false;
//				}
//				try {
//					if (sites == null) {
//						found[4] = true;
//					} else {
//						DocumentId<? extends Category>[] documentIds = content.getCategoryIds();
//
//						for (int j = 0; j < documentIds.length; j++) {
//							DocumentId documentId = documentIds[j];
//							if (workspace.getById(documentId) instanceof Category) {
//								Category category = (Category) workspace.getById(documentId);
//								Content catContent = null;
//								String catName = category.getName();
//								for (String site : sites) {
//									found[4] = site.equalsIgnoreCase(catName);
//									if (found[4])
//										break;
//								}
//
//							}
//						}
//
//					}
//
//				} catch (Exception e) {
//					found[4] = false;
//				}
//
//				if ((found[0] || found[1] || found[2]) && found[3] && found[4]) {
//
//					Map<String, String> dataMap = new HashMap<String, String>();
//					try {
//
//						if (content.getComponent("lnk_DocumentParentOrganization") instanceof LinkComponent) {
//							LinkComponent parentOrg_Link = (LinkComponent) content.getComponent("lnk_DocumentParentOrganization");
//
//							DocumentId parentOrg_docID = parentOrg_Link.getDocumentReference();
//							Content category = (Content) workspace.getById(parentOrg_docID, true);
//							// if (lang.equalsIgnoreCase("ar")) {
//							dataMap.put("parentOrgName", category.getName());
//							dataMap.put("parentOrg", category.getTitle());
//							// Get Ageny Code
//							DocumentId<? extends Category>[] documentIds = category.getCategoryIds();
//							for (int j = 0; j < documentIds.length; j++) {
//								DocumentId documentId = documentIds[j];
//								if (workspace.getById(documentId) instanceof Category) {
//									Category organization = (Category) workspace.getById(documentId);
//									String catName = organization.getName();
//									if (!catName.equals("Ministries") && !catName.equals("Authorities") && !catName.equals("Departments") && !catName.equals("Directorates")
//											&& !catName.equals("Councils") && !catName.equals("Corporations") && !catName.equals("Faculties") && !catName.equals("Funds")
//											&& !catName.equals("Presidencies") && !catName.equals("Diwans") && !catName.equals("Other Agencies") && !catName.equals("Universities")
//											&& !catName.equals("Governorates") && !catName.equals("Municipalities")) {
//										dataMap.put("parentOrgAgenyCode", catName);
//
//									}
//								}
//							}
//							// End Get Ageny Code
//							// } else {
//							//
//							// dataMap.put("parentOrg", category.getName());
//							// }
//
//						}
//						if (content.getComponent("txt_DocumentFileName") instanceof LinkComponent) {
//							LinkComponent docFile_Link = (LinkComponent) content.getComponent("txt_DocumentFileName");
//							dataMap.put("ExcelFile", docFile_Link.getURL());
//						}
//
//						dataMap.put("Title", content.getTitle());
//						try {
//							Calendar c = Calendar.getInstance();
//							c.setTime(content.getPublishedDate());
//							dataMap.put("publishYear", c.get(Calendar.YEAR) + "");
//
//						} catch (Exception ex) {
//							dataMap.put("publishYear", "1999");
//						}
//
//						openGovDataMap.put(content.getName(), dataMap);
//
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//				}
//			}
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return openGovDataMap;
//
//	}
//
//	// /**** ENd search in OPEN GOV DATA
//
//	// START SEARCH BY Publish year IN OPEN GOV DATA
//	public Map<String, Map<String, String>> searchopenGovDataByPublisheYear(String lang, String year, int limit) {
//		// search by year in OPEN GOV DATA
//		int i = 0;
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT));//
//
//		DocumentId categoryDocId = workspace.findByName(DocumentTypes.Category, IWcmUtils.OpenGovData, Workspace.WORKFLOWSTATUS_PUBLISHED).nextId();
//		Map openGovDataMap = new HashMap<String, Map<String, String>>();
//		try {
//			year = year.toLowerCase();
//			DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//			DocumentIdIterator siteAreaDocumentId = workspace.findAllByPath(IWcmUtils.OpenGovData, DocumentTypes.Site, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//
//			DocumentIdIterator newsListDocumentId = searchContent(categoryDocId, lang, siteAreaDocumentId, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE,
//					Workspace.SORT_KEY_PUBLISH_DATE);
//			DocumentId newsDocumentId = null;
//
//			while (newsListDocumentId.hasNext()) {
//				newsDocumentId = newsListDocumentId.nextId();
//				Content content = null;
//				content = (Content) workspace.getById(newsDocumentId);
//				boolean found = false;
//				try {
//					Calendar c = Calendar.getInstance();
//					c.setTime(content.getPublishedDate());
//					found = year.equalsIgnoreCase(String.valueOf(c.get(Calendar.YEAR)));
//				} catch (Exception e) {
//					found = false;
//				}
//
//				if (found) {
//
//					Map<String, String> dataMap = new HashMap<String, String>();
//					try {
//
//						// content.getComponent("lnk_DocumentParentOrganization")
//						// **** LinkComponent
//						// content.getComponent("ML Translations") ****
//						// TextComponent
//						// content.getComponent("txt_DocumentFileName")****
//						// LinkComponent
//
//						if (content.getComponent("lnk_DocumentParentOrganization") instanceof LinkComponent) {
//							LinkComponent parentOrg_Link = (LinkComponent) content.getComponent("lnk_DocumentParentOrganization");
//
//							DocumentId parentOrg_docID = parentOrg_Link.getDocumentReference();
//							Content category = (Content) workspace.getById(parentOrg_docID, true);
//							if (lang.equalsIgnoreCase("ar")) {
//								dataMap.put("parentOrg", category.getTitle());
//							} else {
//								dataMap.put("parentOrg", category.getName());
//							}
//
//						}
//						if (content.getComponent("txt_DocumentFileName") instanceof LinkComponent) {
//							LinkComponent docFile_Link = (LinkComponent) content.getComponent("txt_DocumentFileName");
//							dataMap.put("ExcelFile", docFile_Link.getURL());
//						}
//
//						dataMap.put("Title", content.getTitle());
//						try {
//							Calendar c = Calendar.getInstance();
//							c.setTime(content.getPublishedDate());
//							dataMap.put("publishYear", c.get(Calendar.YEAR) + "");
//
//						} catch (Exception ex) {
//							dataMap.put("publishYear", "1999");
//						}
//
//						openGovDataMap.put(content.getName(), dataMap);
//						i++;
//
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//				}
//				if (openGovDataMap.size() > (limit - 1) || i > (limit - 1)) {
//					break;
//				}
//			}
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return openGovDataMap;
//
//	}
//
//	// END SEARCH BY Publish year IN OPEN GOV DATA
//
//	// End Open Gov data functions
//
//	// Start Saudi Events Functions
//
//	// to get Events Types We used existing function "getEventsCategories"
//
//	/**
//	 * 
//	 * @param date
//	 * @param type
//	 * @param categoriesId
//	 * @param lang
//	 * @param start
//	 * @param limit
//	 * @return
//	 */
//	public List getNewsOrEventsListBYDate(String date, String type, String categoriesId, String lang, int start, int limit) {
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT));
//		DocumentId categoryDocId = workspace.findByName(DocumentTypes.Category, categoriesId, Workspace.WORKFLOWSTATUS_PUBLISHED).nextId();
//		List newsList = new ArrayList<ArrayList<String>>();
//		try {
//			DocumentIdIterator newsListDocumentId = searchContent(categoryDocId, lang, type, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE);
//			DocumentId newsDocumentId = null;
//			int i = 0;
//			limit = start + limit;
//
//			while (newsListDocumentId.hasNext()) {
//				newsDocumentId = newsListDocumentId.nextId();
//				if (i >= start) {
//					Date wcmdate = null;
//					DateFormat format = new SimpleDateFormat("dd MMM yyyy hh:mm:ss z");
//					DateFormat displayedformat = new SimpleDateFormat("dd MMMM yyyy hh:mm");
//
//					Content content = null;
//					content = (Content) workspace.getById(newsDocumentId);
//					ArrayList<String> contentvalue = new ArrayList<String>();
//					contentvalue.add(content.getName());
//					contentvalue.add(content.getTitle());
//
//					try {
//						TextComponent dateHijry = (TextComponent) content.getComponent(IWcmUtils.Component_Name_dateHijry);
//						contentvalue.add(dateHijry.getText());
//
//					} catch (Exception e) {
//
//						contentvalue.add(content.getCreationDate().toGMTString());
//
//					}
//
//					if (content.getComponent(IWcmUtils.Component_Name_imageSummary) instanceof ImageComponent) {
//						ImageComponent image = (ImageComponent) content.getComponent(IWcmUtils.Component_Name_imageSummary);
//						contentvalue.add(image.getResourceURL());
//					}
//					if (content.getComponent(IWcmUtils.Component_Name_imageSummary) instanceof FileComponent) {
//						FileComponent imageFileComponent = (FileComponent) content.getComponent(IWcmUtils.Component_Name_imageSummary);
//						contentvalue.add(imageFileComponent.getResourceURL());
//					}
//					contentvalue.add(content.getDescription());
//
//					try {
//						wcmdate = format.parse(contentvalue.get(2));
//						Date ndate = format.parse(date);
//
//						if ((ndate.getYear() == wcmdate.getYear()) && (ndate.getDate() == wcmdate.getDate()) && (ndate.getMonth() == wcmdate.getMonth())) {
//							contentvalue.set(2, displayedformat.format(wcmdate));
//							newsList.add(contentvalue);
//							i++;
//
//						}
//					} catch (ParseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//
//				if (i == limit) {
//					break;
//				}
//			}
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ComponentNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return newsList;
//
//	}
//
//	public static Date getZeroTimeDate(Date fecha) {
//		Date res = fecha;
//		DateFormat format = new SimpleDateFormat("dd MMM yyyy");
//		Calendar calendar = Calendar.getInstance();
//
//		calendar.setTime(fecha);
//		calendar.set(Calendar.HOUR_OF_DAY, 0);
//		calendar.set(Calendar.MINUTE, 0);
//		calendar.set(Calendar.SECOND, 0);
//		calendar.set(Calendar.MILLISECOND, 0);
//
//		res = calendar.getTime();
//
//		return res;
//	}
//
//	// End Saudi Events Functions
//
//	private DocumentIdIterator searchContentwithlist(DocumentId[] arrayCategoryDocumentId, String lang, Object siteArea, String key1, String key2, String key3) {
//		DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//		DocumentIdIterator siteAreaDocumentId;
//		if (siteArea instanceof DocumentIdIterator) {
//			siteAreaDocumentId = (DocumentIdIterator) siteArea;
//		} else {
//			siteAreaDocumentId = workspace.findAllByPath((String) siteArea, DocumentTypes.SiteArea, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//		}
//
//		DocumentId[] arraySiteAreaDocumentId = new DocumentId[1];
//		arraySiteAreaDocumentId[0] = siteAreaDocumentId.nextId();
//		DocumentIdIterator searchContentDocumentLibrary;
//		if (key1 == null && key2 == null && key3 == null) {
//			searchContentDocumentLibrary = workspace.contentSearch(null, arraySiteAreaDocumentId, arrayCategoryDocumentId, null);
//		} else {
//			searchContentDocumentLibrary = workspace.contentSearch(null, arraySiteAreaDocumentId, arrayCategoryDocumentId, null, false, false, true, false, false, key1, key2, key3, false);
//		}
//		return searchContentDocumentLibrary;
//	}
//
//	public List searchActsAndLawsByAll(String lang, String keyword, String Organizations[], String topics[], String types[]) {
//		Map<String, String> organizationList = getAllGovAgenciesOrganizations(lang);
//
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT));
//
//		DocumentId[] categoryDocId = new DocumentId[2];
//		categoryDocId[0] = workspace.findByName(DocumentTypes.Category, "By Topic", Workspace.WORKFLOWSTATUS_PUBLISHED).nextId(); // searchActsandLawsByTopic(topicc,
//		// lang).nextId();
//		categoryDocId[1] = workspace.findByName(DocumentTypes.Category, "Organizations", Workspace.WORKFLOWSTATUS_PUBLISHED).nextId();// searchActsandLawsByOrganiz(Organizations,
//		// lang).nextId();
//		// categoryDocId[2] = searchActsandLawsByType(typee, lang).nextId();
//
//		List actsAndLawsList = new ArrayList<ArrayList<String>>();
//		try {
//
//			DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//			DocumentIdIterator siteAreaDocumentId = workspace.findAllByPath("Acts and Bylaws", DocumentTypes.Site, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//
//			DocumentIdIterator newsListDocumentId = searchContentwithlist(categoryDocId, lang, siteAreaDocumentId, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE,
//					Workspace.SORT_KEY_PUBLISH_DATE);
//			DocumentId newsDocumentId = null;
//
//			while (newsListDocumentId.hasNext()) {
//				newsDocumentId = newsListDocumentId.nextId();
//				Content content = null;
//				content = (Content) workspace.getById(newsDocumentId);
//				boolean[] found = new boolean[6];
//				String selectedType = "";
//				String selectedTopic = "";
//				String selectedOrganization = "";
//				String organizationName = "";
//				String organizationAgenyCode = "";
//				if (keyword == null || keyword.equals("")) {
//					found[0] = true;
//				} else {
//					try {
//						keyword = keyword.toLowerCase();
//
//						found[0] = (content.getTitle().toLowerCase()).contains(keyword);
//					} catch (Exception e) {
//						found[0] = false;
//					}
//					try {
//						found[1] = (content.getDescription().toLowerCase()).contains(keyword);
//					} catch (Exception e) {
//						found[1] = false;
//					}
//					try {
//						RichTextComponent body = (RichTextComponent) content.getComponent(IWcmUtils.Component_Name_body);
//						found[2] = (body.getRichText().toLowerCase()).contains(keyword);
//					} catch (Exception e) {
//						found[2] = false;
//					}
//				}
//
//				try {
//
//					OptionSelectionComponent type = (OptionSelectionComponent) content.getComponent("Type");
//					for (DocumentId s : type.getCategorySelections()) {
//						selectedType = s.getName();
//						if (types == null) {
//							found[3] = true;
//						} else {
//							for (String newtype : types) {
//								found[3] = newtype.equalsIgnoreCase(s.getName());
//								if (found[3]) {
//									break;
//								}
//							}
//						}
//
//						if (lang.equalsIgnoreCase("ar")) {
//							if (workspace.getById(s) instanceof Category) {
//								Category category = (Category) workspace.getById(s);
//								selectedType = category.getTitle();
//							}
//						}
//
//					}
//
//				} catch (Exception e) {
//					found[3] = false;
//				}
//				try {
//					OptionSelectionComponent topic = (OptionSelectionComponent) content.getComponent("By Topic");
//
//					for (DocumentId s : topic.getCategorySelections()) {
//						selectedTopic = s.getName();
//						if (topics == null) {
//							found[4] = true;
//						} else {
//							for (String newtopic : topics) {
//								found[4] = newtopic.equalsIgnoreCase(s.getName());
//								if (found[4]) {
//									break;
//								}
//							}
//						}
//
//					}
//				} catch (Exception e) {
//					found[4] = false;
//				}
//				try {
//					OptionSelectionComponent organization = (OptionSelectionComponent) content.getComponent("By Organization");
//
//					for (DocumentId s : organization.getCategorySelections()) {
//
//						if (workspace.getById(s) instanceof Category) {
//							Category category = (Category) workspace.getById(s);
//							selectedOrganization = organizationList.get(category.getTitle());
//							// organizationName =category.getTitle();
//							organizationAgenyCode = category.getName();
//
//							if (Organizations == null) {
//								found[5] = true;
//							} else {
//								for (String neworg : Organizations) {
//									found[5] = neworg.equalsIgnoreCase(category.getTitle());
//									if (found[5]) {
//										break;
//									}
//								}
//							}
//
//						}
//
//					}
//				} catch (Exception e) {
//					found[5] = false;
//				}
//				if ((found[0] || found[1] || found[2]) && found[3] && found[4] && found[5]) {
//
//					if (!content.getTitle().equalsIgnoreCase("By Topic") && !content.getName().equalsIgnoreCase("byTopic") && !content.getTitle().equalsIgnoreCase("By Organization")
//							&& !content.getName().equalsIgnoreCase("byOrganization")) {
//						ArrayList<String> contentvalue = new ArrayList<String>();
//						contentvalue.add(content.getName());// 0
//						contentvalue.add(content.getTitle());// 1
//						contentvalue.add(content.getDescription());// 2
//						try {
//							if (content.getComponent("actsorbylawsURL") instanceof ShortTextComponent) {
//								ShortTextComponent webSite = (ShortTextComponent) content.getComponent("actsorbylawsURL");
//								contentvalue.add(webSite.getText());// 3
//
//							}
//						} catch (ComponentNotFoundException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//
//						// organizationName
//						try {
//							LinkComponent linkToOrg = (LinkComponent) content.getComponent("organizationName");
//							DocumentId orgDocumetID = linkToOrg.getDocumentReference();
//							Content organization = (Content) workspace.getById(orgDocumetID);
//							organizationName = organization.getName();
//
//						} catch (ComponentNotFoundException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//
//						contentvalue.add(selectedType);// 4
//						contentvalue.add(selectedTopic);// 5
//						contentvalue.add(selectedOrganization);// 6
//						contentvalue.add(organizationName);// 7
//						contentvalue.add(organizationAgenyCode);// 8
//						actsAndLawsList.add(contentvalue);
//
//					}
//				}
//
//			}
//
//		} catch (DocumentRetrievalException ex) {
//			// TODO Auto-generated catch block
//			ex.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return actsAndLawsList;
//
//	}
//
//	/**
//	 * Search Gov Agencies By All Filters (KeyWord , Types, Agency Code)
//	 * 
//	 * @param lang
//	 * @param keyword
//	 * @param types
//	 * @return
//	 */
//
//	public Map<String, Map<String, String>> searchGovAgenciesByAll(String lang, String keyword, String[] types) {
//		start();
//		Map<String, Map<String, String>> GovAgencies = null;
//
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT));
//		DocumentId categoryDocId = workspace.findByName(DocumentTypes.Category, "Government Agencies Directory", Workspace.WORKFLOWSTATUS_PUBLISHED).nextId();
//
//		try {
//			if (keyword != null) {
//				keyword = keyword.trim().toLowerCase();
//			}
//
//			DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//			DocumentIdIterator siteAreaDocumentId = workspace.findAllByPath("Gov. Agencies Directory", DocumentTypes.Site, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//
//			DocumentIdIterator newsListDocumentId = searchContent(categoryDocId, lang, siteAreaDocumentId, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE,
//					Workspace.SORT_KEY_PUBLISH_DATE);
//			DocumentId newsDocumentId = null;
//
//			GovAgencies = new HashMap<String, Map<String, String>>();
//			StringBuffer sBuffer = new StringBuffer("");
//			if (types != null && types.length > 0) {
//				for (String typename : types) {
//					sBuffer.append("'" + typename + "' ");
//				}
//
//			}
//			while (newsListDocumentId.hasNext()) {
//				newsDocumentId = newsListDocumentId.nextId();
//				Content content = null;
//				content = (Content) workspace.getById(newsDocumentId);
//				boolean[] found = new boolean[5];
//				String orgCode = "";
//				try {
//					if (keyword == null || keyword.trim().equals("")) {
//						found[0] = true;
//					} else {
//						found[0] = (content.getTitle().toLowerCase()).contains(keyword);
//					}
//
//				} catch (Exception e) {
//					found[0] = false;
//				}
//				try {
//					found[1] = (content.getDescription().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[1] = false;
//				}
//				try {
//					RichTextComponent body = (RichTextComponent) content.getComponent(IWcmUtils.Component_Name_body);
//					found[2] = (body.getRichText().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[2] = false;
//				}
//				try {
//					found[3] = (content.getName().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[3] = false;
//				}
//				try {
//					if (types == null || types.length < 1 || sBuffer.length() < 1) {
//						found[4] = true;
//					} else {
//						DocumentId<? extends Category>[] documentIds = content.getCategoryIds();
//						for (int j = 0; j < documentIds.length; j++) {
//							DocumentId documentId = documentIds[j];
//							if (workspace.getById(documentId) instanceof Category) {
//								Category category = (Category) workspace.getById(documentId);
//								String catName = category.getName();
//								if (!catName.equals("Ministries") && !catName.equals("Authorities") && !catName.equals("Departments") && !catName.equals("Directorates") && !catName.equals("Councils")
//										&& !catName.equals("Corporations") && !catName.equals("Faculties") && !catName.equals("Funds") && !catName.equals("Presidencies") && !catName.equals("Diwans")
//										&& !catName.equals("Other Agencies") && !catName.equals("Universities") && !catName.equals("Governorates") && !catName.equals("Municipalities")) {
//									orgCode = category.getName();
//
//								}
//
//								if (sBuffer.indexOf("'" + catName + "'") > -1) {
//									found[4] = true;
//									// break;
//								}
//							}
//						}
//
//					}
//
//				} catch (Exception e) {
//					found[4] = false;
//				}
//				if ((found[0] || found[1] || found[2] || found[3]) && found[4]) {
//
//					try {
//						Map Organization = new HashMap<String, String>();
//						Organization.put(content.getName(), content.getTitle());
//						Organization.put("ORG_CODE", orgCode);
//
//						// mohsen added hbere to get agency code
//						// DocumentId<? extends Category>[] documentIds =
//						// content.getCategoryIds();
//						//
//						// for (int j = 0; j < documentIds.length; j++) {
//						// DocumentId documentId = documentIds[j] ;
//						// if (workspace.getById(documentId) instanceof
//						// Category) {
//						// Category category = (Category)
//						// workspace.getById(documentId);
//						// Content catContent = null ;
//						// String catName= category.getName() ;
//						// if(!catName.equals("Ministries") &&
//						// !catName.equals("Authorities")&&
//						// !catName.equals("Departments")
//						// && !catName.equals("Directorates")&&
//						// !catName.equals("Councils")&&!catName.equals("Corporations")
//						// &&!catName.equals("Faculties")&&!catName.equals("Funds")&&!catName.equals("Presidencies")
//						// &&!catName.equals("Diwans")&&!catName.equals("Other Agencies")&&!catName.equals("Universities")
//						// &&!catName.equals("Governorates")&&!catName.equals("Municipalities")){
//						// orgCode = category.getName();
//						// Organization.put("ORG_CODE", orgCode);
//						// }
//						// }
//						// }
//
//						GovAgencies.put(content.getName(), Organization);
//
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//
//			}
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// catch (ComponentNotFoundException e) {
//		// // TODO Auto-generated catch block
//		// e.printStackTrace();
//		// }
//
//		return GovAgencies;
//
//	}
//
//	/**
//	 * 
//	 * @param serviceId
//	 * @param lang
//	 * @return
//	 */
//	public Map<String, String> getGovAgenyNameAndTitle(String serviceId, String lang) {
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang));
//		DocumentIdIterator docIdIter = workspace.findByName(DocumentTypes.Content, serviceId, Workspace.WORKFLOWSTATUS_PUBLISHED);
//		DocumentId wcmDocumentId = null;
//		Map Service = new HashMap<String, String>();
//		if (docIdIter != null && docIdIter.hasNext()) {
//			wcmDocumentId = docIdIter.nextId();
//			try {
//				Content content = (Content) workspace.getById(wcmDocumentId);
//				Service.put(IWcmUtils.Key_Name, content.getName());
//				Service.put(IWcmUtils.Key_Title, content.getTitle());
//				String orgCode = "";
//				DocumentId<? extends Category>[] documentIds = content.getCategoryIds();
//				for (int j = 0; j < documentIds.length; j++) {
//					DocumentId documentId = documentIds[j];
//					if (workspace.getById(documentId) instanceof Category) {
//						Category category = (Category) workspace.getById(documentId);
//						String catName = category.getName();
//						if (!catName.equals("Ministries") && !catName.equals("Authorities") && !catName.equals("Departments") && !catName.equals("Directorates") && !catName.equals("Councils")
//								&& !catName.equals("Corporations") && !catName.equals("Faculties") && !catName.equals("Funds") && !catName.equals("Presidencies") && !catName.equals("Diwans")
//								&& !catName.equals("Other Agencies") && !catName.equals("Universities") && !catName.equals("Governorates") && !catName.equals("Municipalities")) {
//							orgCode = category.getName();
//
//						}
//
//					}
//				}
//				Service.put("ORG_CODE", orgCode);
//				// DocumentId[] CategoryIds =content.getCategoryIds();
//				// List Categories = new ArrayList<String>();
//				// for(DocumentId CategoryId:CategoryIds){
//				// Category category=(Category) workspace.getById(CategoryId);
//				// Categories.add(category.getTitle());
//				// }
//				// Service.put("Categories", Categories);
//
//			} catch (DocumentRetrievalException e) {
//				e.printStackTrace();
//			} catch (AuthorizationException e) {
//				e.printStackTrace();
//			}
//
//		}
//		return Service;
//	}
//
//	// ///// ended added by IT-BLOCKS Team
//	private UserInfo getUserInfo() {
//
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("com.ibm.mapping.authDataAlias", IPortalConfig.WCM_USER_AlIAS);
//		UserInfo userInfo = new UserInfo();
//
//		javax.security.auth.callback.CallbackHandler callbackHandler;
//		try {
//			callbackHandler = WSMappingCallbackHandlerFactory.getInstance().getCallbackHandler(map, null);
//
//			LoginContext lc = new LoginContext("DefaultPrincipalMapping", callbackHandler);
//			lc.login();
//
//			javax.security.auth.Subject subject = lc.getSubject();
//			java.util.Set creds = subject.getPrivateCredentials();
//			javax.resource.spi.security.PasswordCredential result = (javax.resource.spi.security.PasswordCredential) creds.toArray()[0];
//			userInfo.setUserName(result.getUserName());
//
//			userInfo.setUserPassword(new String(result.getPassword()));
//
//			lc.logout();
//		} catch (LoginException e) {
//
//		} catch (NotImplementedException e1) {
//
//		}
//		return userInfo;
//	}
//
//	public void stop() {
//		WCM_API.getRepository().endWorkspace();
//	}
//
//	public Workspace getWorkspace() {
//		return workspace;
//	}
//
//	public String getRenderingContentMenu(String contentName, String locale) {
//		start();
//		if ("ar".equalsIgnoreCase(locale)) {
//			workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(MCIT_AR));
//		} else {
//			workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(MCIT_EN));
//		}
//		String renderedContnt = null;
//		DocumentIdIterator contentIterator = workspace.findContentByPath(contentName);
//		DocumentId contentId = null;
//		if (contentIterator != null && contentIterator.hasNext()) {
//			contentId = contentIterator.nextId();
//			try {
//				String contentPath = workspace.getPathById(contentId, true, true);
//				renderedContnt = renderContent(contentPath, "MCIT/pt-initialContent");
//			} catch (DocumentRetrievalException e) {
//				e.printStackTrace();
//			} catch (IllegalDocumentTypeException e) {
//				e.printStackTrace();
//			} catch (MalformedURLException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (URISyntaxException e) {
//				e.printStackTrace();
//			}
//			return renderedContnt;
//		} else {
//			return null;
//		}
//	}
//
//	public void getAraContentByMenuId(String menuName) {
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(MCIT_AR));
//		DocumentIdIterator menuIter = workspace.findComponentByName(menuName);
//		if (menuIter.hasNext()) {
//			DocumentId menuID = (DocumentId) menuIter.nextId();
//			try {
//				workspace.getPathById(menuID, true, true);
//			} catch (DocumentRetrievalException e) {
//				e.printStackTrace();
//			} catch (IllegalDocumentTypeException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//	private Map<String, Object> createModifiedContentMap() {
//
//		Map<String, Object> modifiedContent = new HashMap<String, Object>();
//
//		modifiedContent.put(NewActsAndBylaws, new ArrayList());
//		modifiedContent.put(NewCreatedServices, new ArrayList());
//		modifiedContent.put(NewEvents, new ArrayList());
//		modifiedContent.put(NewInitiativesAndNationalPlans, new ArrayList());
//		modifiedContent.put(NewlyCreatedOrganizations, new ArrayList());
//		modifiedContent.put(newNews, new ArrayList());
//		modifiedContent.put(RecentlyUpdatedOrganizations, new ArrayList());
//		modifiedContent.put(RecentlyUpdatedServices, new ArrayList());
//
//		return modifiedContent;
//	}
//
//	public Map findContentModifiedSince(Date date, String locale) {
//
//		Map modifiedContent = null;
//		start();
//		// set current working lib according to local parameter
//		// set the library
//		if (locale.startsWith("ar")) {
//			workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(MCIT_AR));
//		} else {
//			workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(MCIT_EN));
//		}
//
//		DocumentIdIterator contentIterator = null;
//		DocumentId contentId = null;
//		// find content modified since start date
//		contentIterator = workspace.findContentModifiedSince(date);
//		if (contentIterator.hasNext()) {
//			modifiedContent = createModifiedContentMap();
//			contentId = contentIterator.nextId();
//			LOG.info("List of contents modified since " + date);
//			while (contentId != null) {
//				if (contentId.isPublished()) {
//
//					try {
//						String contentPath = workspace.getPathById(contentId, true, true);
//						if (!(contentPath.contains(MOBILE_SERVICES_SITE_AREA))) {
//							AlertContentItem alertContentItem = new AlertContentItem();
//							alertContentItem.setContentPath(contentPath);
//
//							Content content = (Content) workspace.getById(contentId);
//							Date effectiveDate = content.getEffectiveDate();
//							alertContentItem.setEffectiveDate(effectiveDate);
//
//							Date modifiedDate = content.getModifiedDate();
//							alertContentItem.setModifiedDate(modifiedDate);
//							// get site area path
//							String key = getAlertContentCategoryKey(alertContentItem, date);
//							if (key != null) {
//
//								String render = renderContent(contentPath, "MCIT/" + PRESENTATION_TEMPLATE_BULLET_ALERT_ITEM);
//								alertContentItem.setRenderHtml(render);
//
//								((List) modifiedContent.get(key)).add(alertContentItem);
//							}
//						}
//					} catch (DocumentRetrievalException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IllegalDocumentTypeException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (AuthorizationException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (PropertyRetrievalException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (MalformedURLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (URISyntaxException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				contentId = contentIterator.nextId();
//
//			}
//		} else {
//			LOG.info("Could not find any content modified since " + date);
//		}
//		return modifiedContent;
//	}
//
//	public String getAlertContentCategoryKey(AlertContentItem alertContentItem, Date date) {
//		String category = null;
//		String contentPath = alertContentItem.getContentPath();
//		if (contentPath.contains(E_SERVICES_SITE_AREA) || contentPath.contains(OTHER_SERVICES_SITE_AREA)) { // eService
//			// Recently Updated Services
//			if (alertContentItem.getEffectiveDate().before(date)) {
//				category = RecentlyUpdatedServices;
//			}
//			// Newly Created Services
//			else if (alertContentItem.getEffectiveDate().after(date)) {
//				category = NewCreatedServices;
//			}
//		} else if (contentPath.contains(NEWS_SITE_AREA)) { // Recent News
//			category = newNews;
//		} else if (contentPath.contains(EVENTS_SITE_AREA)) {
//			category = NewEvents;
//		} else if (contentPath.contains(ACTS_AND_BYLAWS_SITE_AREA)) {
//			category = NewActsAndBylaws;
//		} else if (contentPath.contains(INITIATIVE_AND_NATIONAL_PLANS_SITE_AREA)) {
//			category = NewInitiativesAndNationalPlans;
//		} else if (contentPath.contains(GOVERNMENT_AGENCIES_SITE_AREA)) {
//			// Recently Updated Organizations
//			if (alertContentItem.getEffectiveDate().before(date)) {
//				category = RecentlyUpdatedOrganizations;
//			}
//			// Recently Created Organizations
//			else if (alertContentItem.getEffectiveDate().after(date)) {
//				category = NewlyCreatedOrganizations;
//			}
//		}
//
//		return category;
//
//	}
//
//	public String renderContent(ServletRequest request, ServletResponse response, String pTemplateName, Content content) throws WcmWrapperException {
//		StringBuffer rendered_content = new StringBuffer();
//
//		Properties props = null;
//		try {
//			props = PortalConfig.getPortalConfigProperties();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		if (workspace != null && pTemplateName != null) {
//			try {
//				RenderingContext rendering_context = workspace.createRenderingContext(request, response, new HashMap(), getWcmWebAppPath(),
//				/*
//				 * configBundle .getString
//				 */props.getProperty(IPortalConfig.WCM_SERVLET_PATH));
//				if (rendering_context != null) {
//					rendering_context.setRenderedContent(content, (SiteArea) workspace.getById((DocumentId) content.getParents().next()));
//					rendering_context.setPresentationTemplateOverride(pTemplateName);
//					String rendered = workspace.render(rendering_context);
//					if (rendered != null)
//						rendered_content.append(rendered);
//				}
//			} catch (OperationFailedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (AuthorizationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (DocumentRetrievalException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ServiceNotAvailableException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return rendered_content.toString();
//	}
//
//	public String renderContent(String contentUrlEncodedPath, String pTemplateName) throws MalformedURLException, IOException, URISyntaxException {
//
//		contentUrlEncodedPath = encodePath(contentUrlEncodedPath);
//
//		String url = getWcmServletPath() + "/" + contentUrlEncodedPath + "?pagedesign=" + pTemplateName;
//
//		HttpURLConnection httpUrlConnection = (HttpURLConnection) (new URI(url).toURL()).openConnection();
//		httpUrlConnection.connect();
//		InputStream istream = httpUrlConnection.getInputStream();
//		byte[] output = new byte[istream.available()];
//
//		istream.read(output);
//		istream.close();
//		httpUrlConnection.disconnect();
//
//		String outpoutStr = new String(output, "UTF-8");
//		outpoutStr = outpoutStr.replace("\uFEFF", "");
//
//		// return new String(output);
//		return outpoutStr;
//	}
//
//	private String getWcmWebAppPath() {
//
//		final String HTTP = "http://";
//		final String COLON = ":";
//		Properties props = null;
//		try {
//			props = PortalConfig.getPortalConfigProperties();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		return HTTP + /* configBundle.getString */props.getProperty(IPortalConfig.WCM_SERVER_NAME) + COLON + /*
//																											 * configBundle
//																											 * .
//																											 * getString
//																											 */props.getProperty(IPortalConfig.WCM_SERVER_PORT)
//				+ /* configBundle.getString */props.getProperty(IPortalConfig.WCM_PATH);
//	}
//
//	private String getWcmServletPath() {
//		final String HTTP = "http://";
//		final String COLON = ":";
//		Properties props = null;
//		try {
//			props = PortalConfig.getPortalConfigProperties();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		return HTTP + /* configBundle.getString */props.getProperty(IPortalConfig.WCM_SERVER_NAME) + COLON + /*
//																											 * configBundle
//																											 * .
//																											 * getString
//																											 */props.getProperty(IPortalConfig.WCM_SERVER_PORT)
//				+ /* configBundle.getString */props.getProperty(IPortalConfig.WCM_PATH) + /*
//																						 * configBundle
//																						 * .
//																						 * getString
//																						 */props.getProperty(IPortalConfig.WCM_SERVLET_PATH);
//	}
//
//	private String encodePath(String contentUrlEncodedPath) {
//		StringBuffer buffer = new StringBuffer();
//		StringTokenizer tokenizer = new StringTokenizer(contentUrlEncodedPath, SPEPARATOR, true);
//		while (tokenizer.hasMoreTokens()) {
//			String token = tokenizer.nextToken();
//			if (!token.equals(SPEPARATOR)) {
//				try {
//					token = URLEncoder.encode(token, "UTF-8");
//				} catch (UnsupportedEncodingException e) {
//				}
//			}
//			buffer.append(token);
//
//		}
//		return buffer.toString();
//		// return URLEncode;
//	}
//
	public String getEmailTemplate(String specificEmailContent, String lang) {
		String render = null;
//		start();
//		String presentationTemplate = null;
//		DocumentIdIterator contentIterator = null;
//		if (lang.startsWith("ar")) {
//			workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(MCIT_AR));
//		} else {
//			workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(MCIT_EN));
//		}
//
//		contentIterator = workspace.findContentByPath(specificEmailContent);
//		presentationTemplate = ALERT_ME_PT;
//
//		DocumentId contentId = null;
//		try {
//
//			if (contentIterator.hasNext()) {
//				contentId = contentIterator.nextId();
//				String contentPath = workspace.getPathById(contentId, true, true);
//				render = renderContent(contentPath, presentationTemplate);
//			}
//
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalDocumentTypeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
		return render;
	}
//
//	public String getServiceName(String servicePath, String contentLib) {
//		LOG.entering("getServiceName", servicePath, contentLib);
//
//		DocumentId pathID = null;
//		String serviceName = null;
//
//		DocumentLibrary docLib = workspace.getDocumentLibrary(contentLib);
//		workspace.setCurrentDocumentLibrary(docLib);
//
//		// workspace.setCurrentDocumentLibrary(workspace
//		// .getDocumentLibrary(contentLib));
//
//		DocumentIdIterator idPathIter = workspace.findContentByPath(servicePath);
//
//		LOG.entering("getServiceName-->idPathIter =" + idPathIter);
//
//		try {
//			if (idPathIter != null && idPathIter.hasNext()) {
//
//				pathID = (DocumentId) idPathIter.next();
//				LOG.entering("getServiceName-->pathID =" + pathID);
//
//				Content co = (Content) workspace.getById((DocumentId) pathID, true);
//
//				LOG.entering("getServiceName-->content =" + co);
//
//				serviceName = co.getTitle();
//
//				LOG.entering("getServiceName-->serviceName =" + serviceName);
//
//				// String serviceTitle = co.getTitle();
//
//				// LOG.entering("getServiceName-->serviceTitle ="+serviceTitle);
//
//			}
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		LOG.exiting("getServiceName", serviceName);
//		return serviceName;
//	}
//
//	// -------------------------------------------
//	// -------- Mobile Applications APIs----------
//	// -------------------------------------------
//
//	private DocumentId getDocumentId(DocumentType docType, String contentLib, String contentName) {
//		DocumentId authoringTemplate = null;
//		DocumentLibrary documentLibrary = workspace.getDocumentLibrary(contentLib);
//		workspace.setCurrentDocumentLibrary(documentLibrary);
//
//		// Find the authoring template
//		DocumentIdIterator authoringIter = workspace.findByName(docType, contentName);
//
//		boolean found = false;
//		while (authoringIter.hasNext() && !found) {
//			authoringTemplate = authoringIter.nextId();
//			if (authoringTemplate.isPublished()) {
//				found = true;
//			}
//		}
//
//		return authoringTemplate;
//	}
//
//	private Map<String, String> getChildrenCategories(String lang, DocumentId categoryId, boolean path) {
//		Map categories = new HashMap<String, String>();
//		try {
//			Category contextCategory = (Category) workspace.getById(categoryId);
//
//			DocumentIdIterator categoryIterator = contextCategory.getChildren();
//			if (categoryIterator.hasNext()) {
//				while (categoryIterator.hasNext()) {
//					DocumentId documentId = categoryIterator.nextId();
//					Category category = (Category) workspace.getById(documentId, true);
//					if (category.isPublished()) {
//						String childId = null;
//						if (path) {
//							childId = workspace.getPathById(documentId, true, true);
//							childId = childId.substring(23, childId.length());
//						} else {
//							childId = category.getName();
//						}
//						if (lang.equalsIgnoreCase("ar")) {
//							categories.put(childId, category.getTitle());
//						} else {
//							categories.put(childId, category.getName());
//						}
//					}
//
//				}
//			}
//
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (PropertyRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalDocumentTypeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return categories;
//	}
//
//	private Map<String, String> getChildrenCategoriesForMobileServises(String lang, DocumentId categoryId, boolean path) {
//		Map categories = new HashMap<String, String>();
//		try {
//			Category contextCategory = (Category) workspace.getById(categoryId);
//
//			DocumentIdIterator categoryIterator = contextCategory.getChildren();
//			if (categoryIterator.hasNext()) {
//				while (categoryIterator.hasNext()) {
//					DocumentId documentId = categoryIterator.nextId();
//					Category category = (Category) workspace.getById(documentId, true);
//					if (category.isPublished()) {
//						String childId = null;
//						if (path) {
//							childId = workspace.getPathById(documentId, true, true);
//							childId = childId.substring(23, childId.length());
//						} else {
//							childId = category.getName();
//						}
//
//						if (getMobileServices(childId, lang, 0, 10).size() > 0) {
//							if (lang.equalsIgnoreCase("ar")) {
//								categories.put(childId, category.getTitle());
//							} else {
//								categories.put(childId, category.getName());
//							}
//						}
//					}
//
//				}
//			}
//
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (PropertyRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalDocumentTypeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return categories;
//	}
//
//	private Map<String, String> getCategories(String parentCategory, String lang, boolean path, boolean returnEmpty) {
//		DocumentId categoryDocId = getDocumentId(DocumentTypes.Category, "MCIT", parentCategory);
//
//		if (lang == null) {
//			lang = "ar";
//		}
//		Map categories;
//		if (returnEmpty) {
//			categories = getChildrenCategoriesForMobileServises(lang, categoryDocId, path);
//		} else {
//			categories = getChildrenCategories(lang, categoryDocId, path);
//		}
//		return categories;
//
//	}
//
//	public List getNewsOrEventsList(String type,String categoriesId,String lang, int start, int limit){
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT));
//		DocumentId categoryDocId =workspace.findByName(DocumentTypes.Category, categoriesId, Workspace.WORKFLOWSTATUS_PUBLISHED).nextId();
//		List newsList=new ArrayList<ArrayList<String>>();
//		try{
//			DocumentIdIterator newsListDocumentId =searchContent(categoryDocId,lang,type,Workspace.SORT_KEY_PUBLISH_DATE,Workspace.SORT_KEY_PUBLISH_DATE,Workspace.SORT_KEY_PUBLISH_DATE); 
//			DocumentId newsDocumentId = null;
//			int i = 0;
//			limit=start+limit;
//			while (newsListDocumentId.hasNext()) {
//				newsDocumentId = newsListDocumentId.nextId();
//				if (i >= start) {
//					Content content = null;
//					content = (Content) workspace.getById(newsDocumentId);
//					ArrayList<String> contentvalue=new ArrayList<String>();
//					contentvalue.add(content.getName());
//					contentvalue.add(content.getTitle());
//					
//						contentvalue.add(content.getEffectiveDate().toGMTString());
//					
//					if(content.getComponent("imageDetails") instanceof ImageComponent){
//						ImageComponent image=(ImageComponent) content.getComponent("imageDetails");
//						contentvalue.add(image.getResourceURL());}
//					if(content.getComponent("imageDetails") instanceof FileComponent){
//						FileComponent imageFileComponent=(FileComponent) content.getComponent("imageDetails");
//						contentvalue.add( imageFileComponent.getResourceURL());
//					}
//					contentvalue.add(content.getDescription());
//					newsList.add(contentvalue);
//				}
//				i++;
//				if(i==limit){break;}
//			}
//		}catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ComponentNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (PropertyRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return newsList;
//
//	}
//
//	public Map<String, String> getTargetAudience(String lang) {
//		start();
//		return getCategories(IWcmUtils.Category_Name_Services, lang, false, false);
//	}
//
//	public Map<String, String> getNewsCategories(String lang) {
//		start();
//		return getCategories(IWcmUtils.Category_Name_News, lang, false, false);
//	}
//
//	public Map<String, String> getEventsCategories(String lang) {
//		start();
//		return getCategories(IWcmUtils.Category_Name_Events, lang, false, false);
//	}
//
//	public Map<String, String> getOrganizationTypes(String lang) {
//        start();
//        Map<String, String> R = new HashMap<String, String>();
//        Map<String, String> x = getCategories(IWcmUtils.Category_OrganizationTypes, lang, false,false);
//        for (String key : x.keySet()) {//x.values()
//              Map<String, String> temp = getCategories(key, lang, false,false);
//              Map<String, String> tempR = new HashMap<String, String>();
//              for (String tkey : temp.keySet()) {//x.values()
//                    tempR.put(ChangeIdtoName(tkey),temp.get(tkey));
//              }
//              R.putAll(tempR);
//        }
//        return R;
//        
//  }
//
//public String ChangeIdtoName(String str) {
//  if (str.equalsIgnoreCase("gadType-funds")) {
//        return "Funds";
//  } else if (str.equalsIgnoreCase("gadType-authorities")) {
//        return "Authorities";
//  } else if (str.equalsIgnoreCase("gadType-corporations")) {
//        return "Corporations";
//  } else if (str.equalsIgnoreCase("gadType-diwans")) {
//        return "Diwans";
//  } else if (str.equalsIgnoreCase("gadType-governorates")) {
//        return "Governorates";
//  } else if (str.equalsIgnoreCase("gadType-councils")) {
//        return "Councils";
//  } else if (str.equalsIgnoreCase("gadType-directorates")) {
//        return "Directorates";
//  } else if (str.equalsIgnoreCase("gadType-Ministries")) {
//        return "Ministries";
//  } else if (str.equalsIgnoreCase("gadType-otherAgencies")) {
//        return "Other Agencies";
//  } else if (str.equalsIgnoreCase("gadType-municipalities")) {
//        return "Municipalities";
//  } else if (str.equalsIgnoreCase("gadType-departments")) {
//        return "Departments";
//  } else if (str.equalsIgnoreCase("gadType-faculties")) {
//        return "Faculties";
//  } else if (str.equalsIgnoreCase("gadType-presidencies")) {
//        return "Presidencies";
//  } else if (str.equalsIgnoreCase("gadType-universitie")) {
//        return "Universities";
//  } else {
//        return "Other Agencies";
//  }
//}
//
//
//	public Map<String, String> getDomains(String parentCategory, String lang) {
//		start();
//		return getCategories(parentCategory, lang, true, false);
//	}
//
//	public Map<String, String> getMobileDomains(String parentCategory, String lang) {
//		start();
//		return getCategories(parentCategory, lang, true, true);
//	}
//
//	private DocumentIdIterator searchServicesContent(String parentCategory, String lang, String siteArea) {
//		start();
//		DocumentIdIterator docIdIter = null;
//		if (!parentCategory.startsWith(IWcmUtils.Services_Path)) {
//			parentCategory = IWcmUtils.Services_Path + parentCategory;
//		}
//		String parent[] = parentCategory.split("/");
//		DocumentId Parent = getDocumentId(DocumentTypes.Category, IWcmUtils.MCIT, parent[(parent.length - 2)]);
//		Category contextCategory;
//		try {
//			contextCategory = (Category) workspace.getById(Parent);
//			DocumentIdIterator categoryIterator = contextCategory.getChildren();
//			DocumentId domainDocumentId = null;
//			while (categoryIterator.hasNext()) {
//				domainDocumentId = categoryIterator.nextId();
//				if (workspace.getPathById(domainDocumentId, true, true).equals(parentCategory)) {
//					break;
//				}
//			}
//			docIdIter = searchContent(domainDocumentId, lang, siteArea, null, null, null);
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			e.printStackTrace();
//		} catch (IllegalDocumentTypeException e) {
//			e.printStackTrace();
//		}
//		return docIdIter;
//	}
//
//	private DocumentIdIterator searchOrganizationsContent(String parentCategory, String lang) {
//		start();
//		DocumentIdIterator docIdIter = null;
//		DocumentId Parent = getDocumentId(DocumentTypes.Category, "MCIT", IWcmUtils.Category_OrganizationTypes);
//		Category contextCategory;
//		try {
//			contextCategory = (Category) workspace.getById(Parent);
//			DocumentIdIterator categoryIterator = contextCategory.getChildren();
//			DocumentId domainDocumentId = null;
//			while (categoryIterator.hasNext()) {
//				domainDocumentId = categoryIterator.nextId();
//				if (workspace.getPathById(domainDocumentId, true, true).equals(IWcmUtils.Organizations_Path + parentCategory)) {
//					break;
//				}
//			}
//			docIdIter = searchContent(domainDocumentId, lang, IWcmUtils.GovAgenciesDirectory_SITE_AREA, null, null, null);
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			e.printStackTrace();
//		} catch (IllegalDocumentTypeException e) {
//			e.printStackTrace();
//		}
//		return docIdIter;
//	}
//
//	private DocumentIdIterator searchContent(DocumentId categoryDocumentId, String lang, Object siteArea, String key1, String key2, String key3) {
//		DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//		DocumentIdIterator siteAreaDocumentId;
//		if (siteArea instanceof DocumentIdIterator) {
//			siteAreaDocumentId = (DocumentIdIterator) siteArea;
//		} else {
//			siteAreaDocumentId = workspace.findAllByPath((String) siteArea, DocumentTypes.SiteArea, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//		}
//		DocumentId[] arrayCategoryDocumentId = new DocumentId[1];
//		arrayCategoryDocumentId[0] = categoryDocumentId;
//		DocumentId[] arraySiteAreaDocumentId = new DocumentId[1];
//		arraySiteAreaDocumentId[0] = siteAreaDocumentId.nextId();
//		DocumentIdIterator searchContentDocumentLibrary;
//		if (key1 == null && key2 == null && key3 == null) {
//			searchContentDocumentLibrary = workspace.contentSearch(null, arraySiteAreaDocumentId, arrayCategoryDocumentId, null);
//		} else {
//			searchContentDocumentLibrary = workspace.contentSearch(null, arraySiteAreaDocumentId, arrayCategoryDocumentId, null, false, false, true, false, false, key1, key2, key3, false);
//		}
//		return searchContentDocumentLibrary;
//	}
//
//	public Map<String, String> getServices(String parentCategory, String lang, int start, int limit) {
//		Map<String, String> Services = null;
//		DocumentIdIterator docIdIter = searchServicesContent(parentCategory, lang, IWcmUtils.E_SERVICES_SITE_AREA);
//		DocumentId wcmDocumentId = null;
//		try {
//			Services = new HashMap<String, String>();
//			int i = 0;
//			limit = start + limit;
//			while (docIdIter != null && docIdIter.hasNext()) {
//				wcmDocumentId = docIdIter.nextId();
//				if (i >= start) {
//					Content content = null;
//					if (workspace.getById(wcmDocumentId) instanceof ContentLink) {
//						ContentLink contentlink = (ContentLink) workspace.getById(wcmDocumentId);
//						content = (Content) workspace.getById(contentlink.getContentId());
//					} else {
//						content = (Content) workspace.getById(wcmDocumentId);
//					}
//					Services.put(content.getName(), content.getTitle());
//				}
//				i++;
//				if (i == limit) {
//					break;
//				}
//			}
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return Services;
//
//	}
//
//	public Map<String, String> getMobileServices(String parentCategory, String lang, int start, int limit) {
//		Map<String, String> Services = null;
//		DocumentIdIterator docIdIter = searchServicesContent(parentCategory, lang, IWcmUtils.MOBILE_SERVICES_SITE_AREA);
//		DocumentId wcmDocumentId = null;
//		try {
//			Services = new HashMap<String, String>();
//			int i = 0;
//			limit = start + limit;
//			while (docIdIter != null && docIdIter.hasNext()) {
//				wcmDocumentId = docIdIter.nextId();
//
//				if (i >= start) {
//					Content content = null;
//					if (workspace.getById(wcmDocumentId) instanceof ContentLink) {
//						ContentLink contentlink = (ContentLink) workspace.getById(wcmDocumentId);
//						content = (Content) workspace.getById(contentlink.getContentId());
//					} else {
//						content = (Content) workspace.getById(wcmDocumentId);
//					}
//					Services.put(content.getName(), content.getTitle());
//				}
//				i++;
//				if (i == limit) {
//					break;
//				}
//			}
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return Services;
//
//	}
//
//	// ////////// delete////////////
//	public String getOpenGovernmentData(String parentCategory) {
//		String data = "&&&&&&&";
//		DocumentIdIterator docIdIter = searchOpenGovernmentData(parentCategory, "Open Government Data", "en");
//		DocumentId wcmDocumentId = null;
//		int i = 0;
//		try {
//			while (docIdIter != null && docIdIter.hasNext()) {
//				wcmDocumentId = docIdIter.nextId();
//				Content content = null;
//				if (workspace.getById(wcmDocumentId) instanceof ContentLink) {
//					ContentLink contentlink = (ContentLink) workspace.getById(wcmDocumentId);
//					content = (Content) workspace.getById(contentlink.getContentId());
//				} else {
//					content = (Content) workspace.getById(wcmDocumentId);
//				}
//				LinkComponent serviceLinkURL;
//				LinkComponent serviceLinkURL2;
//				try {
//					serviceLinkURL = (LinkComponent) content.getComponent("txt_DocumentFileName");
//					serviceLinkURL2 = (LinkComponent) content.getComponent("lnk_DocumentParentOrganization");
//					data += serviceLinkURL2.getLinkText() + "###" + serviceLinkURL.getURL() + "&&&&&&&";
//					i++;
//				} catch (ComponentNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			e.printStackTrace();
//		}
//		return data + i;
//	}
//
//	private DocumentIdIterator searchOpenGovernmentData(String parentCategory, String Category, String lang) {
//		start();
//		DocumentIdIterator docIdIter = null;
//		DocumentId Parent = getDocumentId(DocumentTypes.Category, "MCIT", Category);
//		Category contextCategory;
//		try {
//			contextCategory = (Category) workspace.getById(Parent);
//			DocumentIdIterator categoryIterator = contextCategory.getChildren();
//			DocumentId domainDocumentId = null;
//			ArrayList<DocumentId> list = new ArrayList<DocumentId>();
//			while (categoryIterator.hasNext()) {
//				domainDocumentId = categoryIterator.nextId();
//				list.add(domainDocumentId);
//			}
//			DocumentId[] arrayCategoryDocumentId = list.toArray(new DocumentId[list.size()]);
//			DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//			DocumentIdIterator siteAreaDocumentId = workspace.findAllByPath("Open Government Data", DocumentTypes.SiteArea, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//			DocumentId[] arraySiteAreaDocumentId = new DocumentId[1];
//			arraySiteAreaDocumentId[0] = siteAreaDocumentId.nextId();
//			docIdIter = workspace.contentSearch(null, arraySiteAreaDocumentId, arrayCategoryDocumentId, null);
//
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			e.printStackTrace();
//		}
//		return docIdIter;
//	}
//
//	// ////////////////////////////////////
//	public Map<String, String> getOrganizationsByType(String parentCategory, String lang) {
//		Map<String, String> organizationsByType = null;
//		DocumentIdIterator docIdIter = searchOrganizationsContent(parentCategory, lang);
//		DocumentId wcmDocumentId = null;
//		try {
//			organizationsByType = new HashMap<String, String>();
//			while (docIdIter != null && docIdIter.hasNext()) {
//				wcmDocumentId = docIdIter.nextId();
//				Content content = null;
//				if (workspace.getById(wcmDocumentId) instanceof ContentLink) {
//					ContentLink contentlink = (ContentLink) workspace.getById(wcmDocumentId);
//					content = (Content) workspace.getById(contentlink.getContentId());
//				} else {
//					content = (Content) workspace.getById(wcmDocumentId);
//				}
//				organizationsByType.put(content.getName(), content.getTitle());
//			}
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return organizationsByType;
//
//	}
//
//	private boolean contains(String keyword, String text) {
//		boolean found = false;
//		String[] splitstext = text.split(" ");
//		String[] splitskeyword = keyword.split(",");
//		for (String t : splitstext) {
//			for (String k : splitskeyword) {
//				if (k.equalsIgnoreCase(t) || k.equalsIgnoreCase(text)) {
//					found = true;
//					return found;
//				}
//			}
//		}
//		return found;
//	}
//
//	public Map searchServices(String parentCategory, String lang, String keyword) {
//		Map Services = null;
//		DocumentIdIterator docIdIter = searchServicesContent(parentCategory, lang, IWcmUtils.E_SERVICES_SITE_AREA);
//		DocumentId wcmDocumentId = null;
//		try {
//			Services = new HashMap<String, ArrayList<String>>();
//			while (docIdIter != null && docIdIter.hasNext()) {
//				wcmDocumentId = docIdIter.nextId();
//				Content content = null;
//				if (workspace.getById(wcmDocumentId) instanceof ContentLink) {
//					ContentLink contentlink = (ContentLink) workspace.getById(wcmDocumentId);
//					content = (Content) workspace.getById(contentlink.getContentId());
//				} else {
//					content = (Content) workspace.getById(wcmDocumentId);
//				}
//
//				boolean[] found = new boolean[3];
//				found[0] = contains(keyword, content.getTitle());
//				found[1] = contains(keyword, content.getDescription());
//				LinkComponent organizationName = null;
//				try {
//					organizationName = (LinkComponent) content.getComponent(IWcmUtils.Component_Name_organizationName);
//					found[2] = contains(keyword, organizationName.getLinkText());
//				} catch (Exception e) {
//					found[2] = false;
//				}
//				ArrayList<String> Service = new ArrayList<String>();
//				if (found[0] || found[1] || found[2]) {
//					Service.add(content.getTitle());
//					if (found[1]) {
//						Service.add(content.getDescription());
//					}
//					if (found[2]) {
//						Service.add(organizationName.getLinkText());
//					}
//					Services.put(content.getName(), Service);
//				}
//			}
//
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return Services;
//
//	}
//
//	public Map<String, String> getService(String parentCategory, String lang) {
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang));
//		DocumentIdIterator docIdIter = workspace.findByName(DocumentTypes.Content, parentCategory, Workspace.WORKFLOWSTATUS_PUBLISHED);
//		DocumentId wcmDocumentId = null;
//		Map Service = new HashMap<String, String>();
//		if (docIdIter != null && docIdIter.hasNext()) {
//			wcmDocumentId = docIdIter.nextId();
//			try {
//				Content content = (Content) workspace.getById(wcmDocumentId);
//				Service.put(IWcmUtils.Key_Description, content.getDescription());
//				Service.put(IWcmUtils.Key_Name, content.getName());
//				Service.put(IWcmUtils.Key_Title, content.getTitle());
//
//				LinkComponent serviceLinkURL = (LinkComponent) content.getComponent(IWcmUtils.Component_Name_serviceLinkURL);
//				Service.put(IWcmUtils.Component_Name_serviceLinkURL, new String[]{serviceLinkURL.getURL(), serviceLinkURL.getLinkText()});
//
//				LinkComponent organizationName = (LinkComponent) content.getComponent(IWcmUtils.Component_Name_organizationName);
//				Service.put(IWcmUtils.Component_Name_organizationName, new String[]{serviceLinkURL.getURL(), organizationName.getLinkText()});
//
//				RichTextComponent stepsToImplementService = (RichTextComponent) content.getComponent(IWcmUtils.Component_Name_stepsToImplementService);
//				Service.put(IWcmUtils.Component_Name_stepsToImplementService, stepsToImplementService.getRichText());
//
//				TextComponent howToUseMediaURL = (TextComponent) content.getComponent(IWcmUtils.Component_Name_howToUseMediaURL);
//				Service.put(IWcmUtils.Component_Name_howToUseMediaURL, howToUseMediaURL.getText());
//
//				FileComponent howToUsePDF = (FileComponent) content.getComponent(IWcmUtils.Component_Name_howToUsePDF);
//				Service.put(IWcmUtils.Component_Name_howToUsePDF, howToUsePDF.getResourceURL());
//			} catch (DocumentRetrievalException e) {
//				e.printStackTrace();
//			} catch (AuthorizationException e) {
//				e.printStackTrace();
//			} catch (ComponentNotFoundException e) {
//				e.printStackTrace();
//			}
//
//		}
//		return Service;
//	}
//
//	public Map<String, String> getOrganization(String OrganizationId, String lang) {
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang));
//		DocumentIdIterator docIdIter = workspace.findByName(DocumentTypes.Content, OrganizationId, Workspace.WORKFLOWSTATUS_PUBLISHED);
//		DocumentId wcmDocumentId = null;
//		Map Organization = new HashMap<String, String>();
//		if (docIdIter != null && docIdIter.hasNext()) {
//			wcmDocumentId = docIdIter.nextId();
//			try {
//				Content content = (Content) workspace.getById(wcmDocumentId);
//				Organization.put(IWcmUtils.Key_Description, content.getDescription());
//				Organization.put(IWcmUtils.Key_Name, content.getName());
//				Organization.put(IWcmUtils.Key_Title, content.getTitle());
//
//				TextComponent MLTranslations = (TextComponent) content.getComponent("ML Translations");
//				Organization.put("ML Translations", MLTranslations.getText());
//
//				LinkComponent parentOrganization = (LinkComponent) content.getComponent("parentOrganization");
//				Organization.put("parentOrganization", new String[]{parentOrganization.getURL(), parentOrganization.getLinkText()});
//
//				LinkComponent webSite = (LinkComponent) content.getComponent("webSite");
//				Organization.put("webSite", new String[]{webSite.getURL(), webSite.getLinkText()});
//
//				ShortTextComponent city = (ShortTextComponent) content.getComponent("city");
//				Organization.put("city", city.getText());
//
//				ShortTextComponent postalCode = (ShortTextComponent) content.getComponent("postalCode");
//				Organization.put("postalCode", postalCode.getText());
//
//				ShortTextComponent poBox = (ShortTextComponent) content.getComponent("poBox");
//				Organization.put("poBox", poBox.getText());
//
//				ShortTextComponent phone = (ShortTextComponent) content.getComponent("phone");
//				Organization.put("phone", phone.getText());
//
//				ShortTextComponent fax = (ShortTextComponent) content.getComponent("fax");
//				Organization.put("fax", fax.getText());
//
//				ShortTextComponent email = (ShortTextComponent) content.getComponent("e-mail");
//				Organization.put("e-mail", email.getText());
//
//				ShortTextComponent workingHours = (ShortTextComponent) content.getComponent("workingHours");
//				Organization.put("workingHours", workingHours.getText());
//
//				ShortTextComponent address = (ShortTextComponent) content.getComponent("address");
//				Organization.put("address", address.getText());
//
//				ShortTextComponent googleMapPointX = (ShortTextComponent) content.getComponent("googleMapPointX");
//				Organization.put("googleMapPointX", googleMapPointX.getText());
//
//				ShortTextComponent googleMapPointY = (ShortTextComponent) content.getComponent("googleMapPointY");
//				Organization.put("googleMapPointY", googleMapPointY.getText());
//
//				ShortTextComponent googleMapZoom = (ShortTextComponent) content.getComponent("googleMapZoom");
//				Organization.put("googleMapZoom", googleMapZoom.getText());
//
//				ImageComponent image = (ImageComponent) content.getComponent("logo");
//				Organization.put("logo", image.getResourceURL());
//
//			} catch (DocumentRetrievalException e) {
//				e.printStackTrace();
//			} catch (AuthorizationException e) {
//				e.printStackTrace();
//			} catch (ComponentNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//		return Organization;
//	}
//
//	public Map<String, String> getNewsOrEvents(String newsId, String lang) {
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang));
//		DocumentIdIterator docIdIter = workspace.findByName(DocumentTypes.Content, newsId, Workspace.WORKFLOWSTATUS_PUBLISHED);
//		DocumentId wcmDocumentId = null;
//		Map news = new HashMap<String, String>();
//		if (docIdIter != null && docIdIter.hasNext()) {
//			wcmDocumentId = docIdIter.nextId();
//			try {
//				Content content = (Content) workspace.getById(wcmDocumentId);
//				news.put(IWcmUtils.Key_Name, content.getName());
//				news.put(IWcmUtils.Key_Title, content.getTitle());
//				try {
//					TextComponent dateHijry = (TextComponent) content.getComponent("dateHijry");
//					news.put(IWcmUtils.Component_Name_dateHijry, dateHijry.getText());
//				} catch (Exception e) {
//					news.put(IWcmUtils.Component_Name_CreationDate, content.getCreationDate().toGMTString());
//				}
//				if (content.getComponent(IWcmUtils.Component_Name_imageSummary) instanceof ImageComponent) {
//					ImageComponent image = (ImageComponent) content.getComponent(IWcmUtils.Component_Name_imageSummary);
//					news.put(IWcmUtils.Component_Name_imageSummary, image.getResourceURL());
//				}
//				if (content.getComponent(IWcmUtils.Component_Name_imageSummary) instanceof FileComponent) {
//					FileComponent imageFileComponent = (FileComponent) content.getComponent(IWcmUtils.Component_Name_imageSummary);
//					news.put(IWcmUtils.Component_Name_imageSummary, imageFileComponent.getResourceURL());
//				}
//				RichTextComponent body = (RichTextComponent) content.getComponent(IWcmUtils.Component_Name_body);
//				news.put(IWcmUtils.Component_Name_body, body.getRichText());
//
//			} catch (DocumentRetrievalException e) {
//				e.printStackTrace();
//			} catch (AuthorizationException e) {
//				e.printStackTrace();
//			} catch (ComponentNotFoundException e) {
//				e.printStackTrace();
//			}
//
//		}
//		return news;
//	}
//
//	public String getServiceLinkURL(String servicePath) {
//		LOG.entering("getserviceLinkURL", servicePath);
//
//		DocumentId pathID = null;
//		String serviceLinkURL = null;
//
//		// DocumentLibrary docLib = workspace.getDocumentLibrary(contentLib);
//		// workspace.setCurrentDocumentLibrary(docLib);
//
//		// workspace.setCurrentDocumentLibrary(workspace
//		// .getDocumentLibrary(contentLib));
//
//		DocumentIdIterator idPathIter = workspace.findContentByPath(servicePath);
//
//		// LOG.entering("getServiceName-->idPathIter =" + idPathIter);
//
//		try {
//			if (idPathIter != null && idPathIter.hasNext()) {
//
//				pathID = (DocumentId) idPathIter.next();
//				// LOG.entering("getServiceName-->pathID =" + pathID);
//
//				Content co = (Content) workspace.getById((DocumentId) pathID, true);
//
//				// LOG.entering("getServiceName-->content =" + co);
//
//				LinkComponent servicelink = (LinkComponent) co.getComponent("serviceLinkURL");
//				serviceLinkURL = servicelink.getURL();
//
//				// LOG.entering("getServiceName-->serviceName =" + serviceName);
//
//				// String serviceTitle = co.getTitle();
//
//				// LOG.entering("getServiceName-->serviceTitle ="+serviceTitle);
//
//			}
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ComponentNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		LOG.exiting("getServiceName", serviceLinkURL);
//		return serviceLinkURL;
//	}
//
//	public Map<String, String[]> getServiceCart() {
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary("SRS"));
//		DocumentIdIterator docIdIter = workspace.findByType(DocumentTypes.Site);
//		DocumentId wcmDocumentId = null;
//		Map serviceCart = new HashMap<String, String[]>();
//		int i = 0;
//		while (docIdIter != null && docIdIter.hasNext()) {
//			wcmDocumentId = docIdIter.nextId();
//			try {
//				DocumentId[] arraySiteAreaDocumentId = new DocumentId[1];
//				arraySiteAreaDocumentId[0] = wcmDocumentId;
//				DocumentIdIterator searchContentDocumentLibrary;
//				searchContentDocumentLibrary = workspace.contentSearch(null, arraySiteAreaDocumentId, null, null);
//				DocumentId contentDocumentId = null;
//				while (searchContentDocumentLibrary != null && searchContentDocumentLibrary.hasNext()) {
//					contentDocumentId = searchContentDocumentLibrary.nextId();
//					Content content = (Content) workspace.getById(contentDocumentId);
//					String[] value = new String[6];
//					value[1] = content.getTitle();
//					value[0] = wcmDocumentId.getName();
//
//					try {
//						OptionSelectionComponent serviceType = (OptionSelectionComponent) content.getComponent("serviceType");
//						for (DocumentId serviceTypeId : serviceType.getCategorySelections()) {
//							Category CatServiceType = (Category) workspace.getById(serviceTypeId);
//							value[2] = CatServiceType.getTitle();
//						}
//					} catch (Exception e) {
//					}
//					try {
//						ShortTextComponent serviceNumber = (ShortTextComponent) content.getComponent("serviceNumber");
//						value[3] = serviceNumber.getText();
//					} catch (Exception e) {
//					}
//					try {
//						OptionSelectionComponent maturityLevel = (OptionSelectionComponent) content.getComponent("maturityLevel");
//						for (DocumentId maturityLevelId : maturityLevel.getCategorySelections()) {
//							Category CatMaturityLevel = (Category) workspace.getById(maturityLevelId);
//							value[4] = CatMaturityLevel.getTitle();
//						}
//
//					} catch (Exception e) {
//					}
//					try {
//						LinkComponent serviceNumber = (LinkComponent) content.getComponent("organizationName");
//						value[5] = serviceNumber.getLinkText();
//					} catch (Exception e) {
//					}
//					i++;
//					serviceCart.put(i, value);
//
//				}
//
//			} catch (DocumentRetrievalException e) {
//				e.printStackTrace();
//			} catch (AuthorizationException e) {
//				e.printStackTrace();
//			}
//
//		}
//		return serviceCart;
//	}
//
//	public List getNewsListV2(String type, String categoriesId, String lang, int start, int limit) {
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT));
//		DocumentId categoryDocId = workspace.findByName(DocumentTypes.Category, categoriesId, Workspace.WORKFLOWSTATUS_PUBLISHED).nextId();
//		List newsList = new ArrayList<ArrayList<String>>();
//		try {
//			DocumentIdIterator newsListDocumentId = searchContent(categoryDocId, lang, type, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE);
//			DocumentId newsDocumentId = null;
//			int i = 0;
//			limit = start + limit;
//			while (newsListDocumentId.hasNext()) {
//				newsDocumentId = newsListDocumentId.nextId();
//				if (i >= start) {
//					Content content = null;
//					content = (Content) workspace.getById(newsDocumentId);
//					ArrayList<String> contentvalue = new ArrayList<String>();
//					contentvalue.add(content.getName());
//					contentvalue.add(content.getTitle());
//					String dateH = "";
//					String dateG = "";
//					TextComponent dateHijry = (TextComponent) content.getComponent(IWcmUtils.Component_Name_dateHijry);
//					dateH = dateHijry.getText();
//					SimpleDateFormat format;
//					if (lang.equalsIgnoreCase("ar")) {
//						if (!dateH.equals("")) {
//							dateH = convertNumbersToArabic(dateH);
//						}
//						try {
//							format = new SimpleDateFormat("yyyy/MM/dd");
//							dateG = convertNumbersToArabic(format.format(content.getEffectiveDate()));
//						} catch (PropertyRetrievalException e) {
//							e.printStackTrace();
//						}
//					} else {
//						try {
//							format = new SimpleDateFormat("dd/MM/yyyy");
//							dateG = format.format(content.getEffectiveDate());
//						} catch (PropertyRetrievalException e) {
//							e.printStackTrace();
//						}
//					}
//					contentvalue.add(dateH);
//					contentvalue.add(dateG);
//
//					if (content.getComponent(IWcmUtils.Component_Name_imageSummary) instanceof ImageComponent) {
//						ImageComponent image = (ImageComponent) content.getComponent(IWcmUtils.Component_Name_imageSummary);
//						contentvalue.add(image.getResourceURL());
//					}
//					if (content.getComponent(IWcmUtils.Component_Name_imageSummary) instanceof FileComponent) {
//						FileComponent imageFileComponent = (FileComponent) content.getComponent(IWcmUtils.Component_Name_imageSummary);
//						contentvalue.add(imageFileComponent.getResourceURL());
//					}
//					contentvalue.add(content.getDescription());
//					newsList.add(contentvalue);
//				}
//				i++;
//				if (i == limit) {
//					break;
//				}
//			}
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ComponentNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return newsList;
//
//	}
//
//	public Map<String, String> getNewsV2(String newsId, String lang) {
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang));
//		DocumentIdIterator docIdIter = workspace.findByName(DocumentTypes.Content, newsId, Workspace.WORKFLOWSTATUS_PUBLISHED);
//		DocumentId wcmDocumentId = null;
//		Map news = new HashMap<String, String>();
//		if (docIdIter != null && docIdIter.hasNext()) {
//			wcmDocumentId = docIdIter.nextId();
//			try {
//				Content content = (Content) workspace.getById(wcmDocumentId);
//				news.put(IWcmUtils.Key_Name, content.getName());
//				news.put(IWcmUtils.Key_Title, content.getTitle());
//				String dateH = "";
//				String dateG = "";
//				TextComponent dateHijry = (TextComponent) content.getComponent("dateHijry");
//				dateH = dateHijry.getText();
//				SimpleDateFormat format;
//				if (lang.equalsIgnoreCase("ar")) {
//					if (!dateH.equals("")) {
//						dateH = convertNumbersToArabic(dateH);
//					}
//					try {
//						format = new SimpleDateFormat("yyyy/MM/dd");
//						dateG = convertNumbersToArabic(format.format(content.getEffectiveDate()));
//					} catch (PropertyRetrievalException e) {
//						e.printStackTrace();
//					}
//				} else {
//					try {
//						format = new SimpleDateFormat("dd/MM/yyyy");
//						dateG = format.format(content.getEffectiveDate());
//					} catch (PropertyRetrievalException e) {
//						e.printStackTrace();
//					}
//				}
//
//				news.put(IWcmUtils.Component_Name_dateHijry, dateH);
//				news.put("dateGregorian", dateG);
//
//				if (content.getComponent(IWcmUtils.Component_Name_imageSummary) instanceof ImageComponent) {
//					ImageComponent image = (ImageComponent) content.getComponent(IWcmUtils.Component_Name_imageSummary);
//					news.put(IWcmUtils.Component_Name_imageSummary, image.getResourceURL());
//				}
//				if (content.getComponent(IWcmUtils.Component_Name_imageSummary) instanceof FileComponent) {
//					FileComponent imageFileComponent = (FileComponent) content.getComponent(IWcmUtils.Component_Name_imageSummary);
//					news.put(IWcmUtils.Component_Name_imageSummary, imageFileComponent.getResourceURL());
//				}
//				RichTextComponent body = (RichTextComponent) content.getComponent(IWcmUtils.Component_Name_body);
//				news.put(IWcmUtils.Component_Name_body, body.getRichText());
//
//			} catch (DocumentRetrievalException e) {
//				e.printStackTrace();
//			} catch (AuthorizationException e) {
//				e.printStackTrace();
//			} catch (ComponentNotFoundException e) {
//				e.printStackTrace();
//			}
//
//		}
//		return news;
//	}
//
//	private String convertNumbersToArabic(String str) {
//		char[] arabicChars = {'٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩'};
//		StringBuilder builder = new StringBuilder();
//		for (int i = 0; i < str.length(); i++) {
//			if (Character.isDigit(str.charAt(i))) {
//				builder.append(arabicChars[(int) (str.charAt(i)) - 48]);
//			} else {
//				builder.append(str.charAt(i));
//			}
//		}
//		return builder.toString();
//	}
//
//	public List searchNews(String lang, String keyword) {
//		start();
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT));
//		DocumentId categoryDocId = workspace.findByName(DocumentTypes.Category, "News", Workspace.WORKFLOWSTATUS_PUBLISHED).nextId();
//		List newsList = new ArrayList<ArrayList<String>>();
//		try {
//			keyword = keyword.toLowerCase();
//			DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//			DocumentIdIterator siteAreaDocumentId = workspace.findAllByPath("News", DocumentTypes.Site, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//
//			DocumentIdIterator newsListDocumentId = searchContent(categoryDocId, lang, siteAreaDocumentId, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE,
//					Workspace.SORT_KEY_PUBLISH_DATE);
//
//			DocumentId newsDocumentId = null;
//			int i = 0, l = 0;
//			while (newsListDocumentId.hasNext()) {
//				newsDocumentId = newsListDocumentId.nextId();
//				Content content = null;
//				content = (Content) workspace.getById(newsDocumentId);
//				boolean[] found = new boolean[3];
//				try {
//					found[0] = (content.getTitle().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[0] = false;
//				}
//				try {
//					found[1] = (content.getDescription().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[0] = false;
//				}
//				try {
//					RichTextComponent body = (RichTextComponent) content.getComponent(IWcmUtils.Component_Name_body);
//					found[2] = (body.getRichText().toLowerCase()).contains(keyword);
//				} catch (Exception e) {
//					found[0] = false;
//				}
//				if (found[0] || found[1] || found[2]) {
//					ArrayList<String> contentvalue = new ArrayList<String>();
//					contentvalue.add(content.getName());
//					contentvalue.add(content.getTitle());
//					contentvalue.add(content.getDescription());
//					String dateH = "";
//					String dateG = "";
//					TextComponent dateHijry = (TextComponent) content.getComponent(IWcmUtils.Component_Name_dateHijry);
//					dateH = dateHijry.getText();
//					SimpleDateFormat format;
//					if (lang.equalsIgnoreCase("ar")) {
//						if (!dateH.equals("")) {
//							dateH = convertNumbersToArabic(dateH);
//						}
//						try {
//							format = new SimpleDateFormat("yyyy/MM/dd");
//							dateG = convertNumbersToArabic(format.format(content.getEffectiveDate()));
//						} catch (PropertyRetrievalException e) {
//							e.printStackTrace();
//						}
//					} else {
//						try {
//							format = new SimpleDateFormat("dd/MM/yyyy");
//							dateG = format.format(content.getEffectiveDate());
//						} catch (PropertyRetrievalException e) {
//							e.printStackTrace();
//						}
//					}
//					contentvalue.add(dateH);
//					contentvalue.add(dateG);
//
//					if (content.getComponent(IWcmUtils.Component_Name_imageSummary) instanceof ImageComponent) {
//						ImageComponent image = (ImageComponent) content.getComponent(IWcmUtils.Component_Name_imageSummary);
//						contentvalue.add(image.getResourceURL());
//					}
//					if (content.getComponent(IWcmUtils.Component_Name_imageSummary) instanceof FileComponent) {
//						FileComponent imageFileComponent = (FileComponent) content.getComponent(IWcmUtils.Component_Name_imageSummary);
//						contentvalue.add(imageFileComponent.getResourceURL());
//					}
//					newsList.add(contentvalue);
//				}
//				i++;
//				if (i > 150 || newsList.size() > 20 || l == 4) {
//					if (newsList.size() < 5 && l != 4) {
//						i = 0;
//						l++;
//					} else {
//						break;
//					}
//				}
//			}
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ComponentNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return newsList;
//
//	}
//
//	// edited by ahnmed abdelhafeez
//
//	public Map<String, Map<String, String>> searchGovAgenciesByKeyword(String lang, String keyword, int start, int limit) {
//		start();
//		Map<String, Map<String, String>> GovAgencies = null;
//
//		workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT));// //By
//																							// Topic
//		DocumentId categoryDocId = workspace.findByName(DocumentTypes.Category, "Government Agencies Directory", Workspace.WORKFLOWSTATUS_PUBLISHED).nextId();
//
//		try {
//			keyword = keyword.toLowerCase();
//			DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//			DocumentIdIterator siteAreaDocumentId = workspace.findAllByPath("Gov. Agencies Directory", DocumentTypes.Site, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//
//			DocumentIdIterator newsListDocumentId = searchContent(categoryDocId, lang, siteAreaDocumentId, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE,
//					Workspace.SORT_KEY_PUBLISH_DATE);
//			DocumentId newsDocumentId = null;
//			int i = 0, l = 0;
//			limit = 100;
//			GovAgencies = new HashMap<String, Map<String, String>>();
//
//			while (newsListDocumentId.hasNext()) {
//				newsDocumentId = newsListDocumentId.nextId();
//				if (i >= start) {
//					Content content = null;
//					content = (Content) workspace.getById(newsDocumentId);
//					boolean[] found = new boolean[4];
//					try {
//						found[0] = (content.getTitle().toLowerCase()).contains(keyword);
//					} catch (Exception e) {
//						found[0] = false;
//					}
//					try {
//						found[1] = (content.getDescription().toLowerCase()).contains(keyword);
//					} catch (Exception e) {
//						found[1] = false;
//					}
//					try {
//						RichTextComponent body = (RichTextComponent) content.getComponent(IWcmUtils.Component_Name_body);
//						found[2] = (body.getRichText().toLowerCase()).contains(keyword);
//					} catch (Exception e) {
//						found[2] = false;
//					}
//					try {
//						found[3] = (content.getName().toLowerCase()).contains(keyword);
//					} catch (Exception e) {
//						found[3] = false;
//					}
//					if (found[0] || found[1] || found[2] || found[3]) {
//
//						i++;
//
//						try {
//							Map Organization = new HashMap<String, String>();
//							Organization.put(content.getName(), content.getTitle());
//
//							// mohsen added hbere to get agency code
//							DocumentId<? extends Category>[] documentIds = content.getCategoryIds();
//							String orgCode = "";
//							for (int j = 0; j < documentIds.length; j++) {
//								DocumentId documentId = documentIds[j];
//								if (workspace.getById(documentId) instanceof Category) {
//									Category category = (Category) workspace.getById(documentId);
//									Content catContent = null;
//									String catName = category.getName();
//									if (!catName.equals("Ministries") && !catName.equals("Authorities") && !catName.equals("Departments") && !catName.equals("Directorates")
//											&& !catName.equals("Councils") && !catName.equals("Corporations") && !catName.equals("Faculties") && !catName.equals("Funds")
//											&& !catName.equals("Presidencies") && !catName.equals("Diwans") && !catName.equals("Other Agencies") && !catName.equals("Universities")
//											&& !catName.equals("Governorates") && !catName.equals("Municipalities")) {
//										orgCode = category.getName();
//										Organization.put("ORG_CODE", orgCode);
//									}
//								}
//							}
//
//							GovAgencies.put(content.getName(), Organization);
//
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				}
//				if (i == limit) {
//					break;
//				}
//			}
//		} catch (DocumentRetrievalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// catch (ComponentNotFoundException e) {
//		// // TODO Auto-generated catch block
//		// e.printStackTrace();
//		// }
//
//		return GovAgencies;
//
//	}
//	
//	public String [] getGovAgenciesByOrgcode(String orgCode,String lang) {
//		String [] orgInfo= null; 
//		try {
//			
//			orgInfo= new String [2];					
//			Content content= null;
//			start();
//			workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(IWcmUtils.MCIT));
//			DocumentIdIterator categoryDocId = workspace.findByName(DocumentTypes.Category, "Organizations" , Workspace.WORKFLOWSTATUS_PUBLISHED);
//			DocumentId categoryIdParr = categoryDocId.nextId();
//			Category catMAin = workspace.getById(categoryIdParr);
//			
//			DocumentIdIterator categoryIterator = catMAin.getChildren();
//			DocumentId orgCategory = null ;
//			while(categoryIterator.hasNext()){
//				DocumentId categoryId = categoryIterator.nextId();
//				Category cat = workspace.getById(categoryId);
//				String catTitle = cat.getTitle();
//				if(catTitle != null && catTitle.equalsIgnoreCase("organization-"+orgCode)){
//					orgCategory = categoryId ;
//					break;
//				}
//			}
//			
//			DocumentLibrary[] dl = {workspace.getDocumentLibrary(IWcmUtils.MCIT + "_" + lang)};
//			DocumentIdIterator siteAreaDocumentId = workspace.findAllByPath("Gov. Agencies Directory", DocumentTypes.Site, Workspace.WORKFLOWSTATUS_PUBLISHED, dl);
//			DocumentIdIterator documentIterator = searchContent(orgCategory, lang, siteAreaDocumentId, Workspace.SORT_KEY_PUBLISH_DATE, Workspace.SORT_KEY_PUBLISH_DATE,
//								Workspace.SORT_KEY_PUBLISH_DATE);
//			
//			DocumentId newsDocumentId = null ;
//			while(documentIterator.hasNext()){
//				newsDocumentId = documentIterator.nextId();
//				content= (Content) workspace.getById(newsDocumentId);
//				orgInfo[0]= content.getTitle();
//				LinkComponent webSite= (LinkComponent) content.getComponent("webSite");
//				orgInfo[1]= webSite.getURL();
//			}
//		} catch (DocumentRetrievalException e) {
//			e.printStackTrace();
//		} catch (AuthorizationException e) {
//			e.printStackTrace();
//		}catch (ComponentNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		return orgInfo;
//	}

}