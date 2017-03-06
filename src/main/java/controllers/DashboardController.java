package controllers;

import domain.BookRequest;
import domain.Lessor;
import domain.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import services.AdministratorService;

import java.util.Collection;
import java.util.Map;

/**
 * Created by mruwzum on 19/12/16.
 */
@Controller
@RequestMapping("admin")
public class DashboardController extends AbstractController {

    public DashboardController() {
        super();
    }


    @Autowired
    private AdministratorService administratorService;


    @RequestMapping(value = "/dashboard")
    public ModelAndView dashboard() {
        ModelAndView res;

   //DASHBOARD C
    Double q1 = administratorService.averageAcceptedRequestPerLessor();
    Double q2 = administratorService.averageDeniedRequestPerLessor();
    Double q3 = administratorService.averageAcceptedRequestPerTenat();
    Double q4 = administratorService.averageDeniedRequestPerTenat();
    Collection<Lessor> q5 = administratorService.lessorsWhoHasAcceptedBookRequests();
    Collection<Lessor> q6 = administratorService.lessorsWhoHasDeniedBookRequests();
    Collection<Lessor> q7 = administratorService.lessorsWhoHasPendingBookRequests();
    Collection<Tenant> q8 = administratorService.getTenantWithMoreApprovedBookRequest();
    Collection<Tenant> q9 = administratorService.getTenantWithMoreDeniedBookRequest();
    Collection<Tenant> q10 = administratorService.getTenantWithMorePendingBookRequest();
    Map<Tenant, Double> q11 = administratorService.ratioOfRequestedVSApprovedRequestedPerTenant();
    Map<Lessor, Double> q12 = administratorService.ratioOfRequestedVSApprovedRequestedPerLessor();
    Double q13 = administratorService.averageResultPerFinder();
    Integer q14 = administratorService.MaximumResultPerFinder();
    Integer q15 = administratorService.MinimumResultPerFinder();
//
//    User q4 = adminService.getUserWhoAuthoredMoreRecipes();
//
//    Collection<Integer> q5 = adminService.minimumNumberOfRecipesQualifiedForAContest();
//    Collection<Integer> q6 = adminService.averageNumberOfRecipesQualifiedForAContest();
//    Collection<Integer> q7 = adminService.maximumNumberOfRecipesQualifiedForAContest();
//
//    Collection<Contest> q8 = adminService.contestForWhichMoreRecipesHasQualified();
//
//    Double q9 = adminService.averageOfStepsPerRecipe();
//    Double q10 = adminService.standartDeviationOfNumberOfStepsPerRecipe();
//
//    Double q11 = adminService.averageOfIngredientsPerRecipe();
//    Double q12 = adminService.standartDeviationOfNumberOfIngredientsPerRecipe();
//
//    Collection<User> q13 = adminService.usersInDescendingPopularity();
//    Collection<User> q14 = adminService.usersInDescendingOrderByAverageOfLikesPerRecipe();
//
//    //DASHBOARD B
//
//        Collection<Integer> q15 =adminService.minimumNumberOfCampaignsPerSponsor();
//
//        Collection<Integer> q16 = adminService.averageNumberOfCampaignsPerSponsor();
//
//        Collection<Integer> q17 = adminService.maximumNumberOfCampaignsPerSponsor();
//
//        Collection<Integer> q18 = adminService.minumumNumberOfActiveCampaignsPerSponsor();
//
//        Collection<Integer> q19 = adminService.maximumNumberOfActiveCampaignsPerSponsor();
//
//        Collection<Integer> q20 = adminService.averageNumberOfActiveCampaignsPerSponsor();
//
//        Collection<Integer> q21 = adminService.maxnumberOfCampaignsPerSponsor();
//
//        Collection<Integer> q22 = adminService.biggestCostesOfMonthlyBills();
//
//        Collection<Integer> q23= adminService.averageAndStandartDevOfPaidBills();
//
//        Sponsor q24 = adminService.sponsorHowHasntMangaedAnyCampaingInLastTreemonths();
//
//        String q25 = adminService.nombreCompaniaQueHaGastadoMenosDeLaMediaEnSusCampanas();
//
//        String q26 = adminService.nameOfCompanymenos90porciento();
//
//        //DASHBOARD A -----------------------------------------------------------------------------------------------
//
//         Collection<Integer> q27 = adminService.minumumandmaximumandaverageNumberOfMasterClassesPerCook();
//
//         Collection<Integer> q28 = adminService.averageOfLearningMaterialsPerMasterClass();
//
//         Long q29 = adminService.numberOfPromotedMasterClasses();
//
//         Collection<Cook> q30 = adminService.cookByPromotedMasterClasses();
//
////         Collection<Integer> q31 = adminService.averageOfMasterClassesPromotedByAdmin();
//
//    res = new ModelAndView("admin/dashboard");
//        //C
//        res.addObject("q1", q1);
//        res.addObject("q2", q2);
//        res.addObject("q3", q3);
//        res.addObject("q4", q4.getName());
//        res.addObject("q5", q5);
//        res.addObject("q6", q6);
//        res.addObject("q7", q7);
//        res.addObject("q8", q8);
//        res.addObject("q9", q9);
//        res.addObject("q10", q10);
//        res.addObject("q11", q11);
        //TODO aqui tienes que meter un q11.keyset (Personas) y un q11.values (Ratios)

//        res.addObject("q12", q12);
// /    /TODO aqui tienes que meter un q12.keyset (Personas) y un q12.values (Ratios)
//         res.addObject("q13", q13);
//        res.addObject("q14", q14);
//        //B
//        res.addObject("q15", q15);
//        res.addObject("q16", q16);
//        res.addObject("q17", q17);
//        res.addObject("q18", q18);
//        res.addObject("q19", q19);
//        res.addObject("q20", q20);
//        res.addObject("q21", q21);
//        res.addObject("q22", q22);
//        res.addObject("q23", q23);
//        res.addObject("q24", q24.getName());
//        res.addObject("q25", q25);
//        res.addObject("q26", q26);
//        //A
//        res.addObject("q27", q27);
//        res.addObject("q28", q28);
//        res.addObject("q29", q29);
//        res.addObject("q30", q30);
////        res.addObject("q31", q31);
//
//        return res;
//    }

        res = new ModelAndView();
        return res;
    }
}
