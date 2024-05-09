package com.shubham.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.shubham.app.exception.InvalidParameters;
import com.shubham.app.render.RenderSatelliteTemplate;
import com.shubham.app.service.SatelliteService;

import java.math.BigInteger;
import java.util.Objects;

import static com.shubham.app.controller.LauncherController.ZERO_LENGTH_STRING;

@Controller
public class SatelliteController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private RenderSatelliteTemplate renderSatelliteTemplate;
    @Autowired
    private SatelliteService satelliteService;

    /**
     * Endpoint to render all satellites
     *
     * @param model
     * @param searchText
     *            : the search filter
     * @param pageNumber
     *            : the pagination current page number
     * @param pageSize
     *            : the pagination page size
     * @return
     */
    @GetMapping(value = {"/web/satellites", "", "/"})
    public String getLaunchers(Model model, @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam(value = "pageNumber", required = false) BigInteger pageNumber,
            @RequestParam(value = "pageSize", required = false) BigInteger pageSize) {

        logger.info("Admin all satellites called with pageNumber : {}, pageSize : {} and searchText : {}", pageNumber,
                pageSize, searchText);
        model.addAttribute("errorMessage", model.asMap().get("errorMessage"));

        renderSatelliteTemplate.renderAllSatellite(model, pageNumber, pageSize, searchText);

        return "satellites";
    }

    /**
     * Endpoint to render the page that contains the form to create the new
     * satellite
     */
    @GetMapping(value = {"/web/add-satellite"})
    public String getLaunchers(@ModelAttribute("satelliteId") String satelliteId, Model model) {

        logger.info("adding new satellite form page called");
        model.addAttribute("errorMessage", model.asMap().get("errorMessage"));
        if (!Objects.equals(satelliteId, ZERO_LENGTH_STRING)) {
            logger.info("edit satellite page specific for satelliteId : {}", satelliteId);
            renderSatelliteTemplate.renderDesiredSatelliteEditPage(satelliteId, model);
        }

        return "new-satellite";
    }

    /**
     * Endpoint used, when user fills and submits the form for creating a new
     * satellite
     */
    @PostMapping(value = {"/web/satellites/create-satellite"})
    @ResponseBody
    public Object createOrUpdateLauncher(
            @RequestParam(value = "satelliteIdExisting", required = false) String satelliteIdExisting,
            @RequestParam(value = "satelliteId", required = false) String satelliteId,
            @RequestParam(value = "country") String country, @RequestParam(value = "launchDate") String launchDate,
            @RequestParam(value = "mass") Double mass, @RequestParam(value = "launcherId") String launcherId,
            Model model, RedirectAttributes redirectAttrs) {

        logger.info(
                "Create new satellite called with satelliteId : {}, satelliteId : {} country : {}, launchedDate : {}, mass : {}, and launcherId : {}",
                satelliteIdExisting, satelliteId, country, launchDate, mass, launcherId);

        try {
            // creating a new-satellite
            satelliteService.createOrUpdateSatellites(satelliteIdExisting, satelliteId, country, launchDate, mass,
                    launcherId, redirectAttrs);
        } catch (InvalidParameters e) {
            logger.error("error while creating a launcher : {}", e.getMessage());
            redirectAttrs.addFlashAttribute("errorMessage", "Invalid parameters : " + e.getMessage());
        } catch (Exception e) {
            logger.error("error while creating a launcher : {}", e.getMessage());
            redirectAttrs.addFlashAttribute("errorMessage", "Unable to create launcher : " + e.getMessage());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        logger.info("Redirecting to all launchers page");
        return new RedirectView("/web/satellites");
    }

    @PostMapping(value = {"/web/satellites/delete-satellite"})
    @ResponseBody
    public Object deleteLauncher(@RequestParam(value = "satelliteId") String satelliteId, Model model,
            RedirectAttributes redirectAttrs) {

        logger.info("Deleting the existing satellite called with id: {}", satelliteId);
        try {
            satelliteService.deleteSatellite(satelliteId);
            redirectAttrs.addFlashAttribute("successMessage",
                    "Successfully deleted existing satellite with satelliteId : " + satelliteId);
        } catch (Exception e) {
            logger.error("error while deleting the satellite : {}", e.getMessage());
            redirectAttrs.addFlashAttribute("errorMessage", "Unable to delete launcher with cause :" + e.getMessage());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        logger.info("Redirecting to all launchers page");
        return new RedirectView("/web/satellites");
    }

    @PostMapping(value = {"/web/update-satellite"})
    @ResponseBody
    public RedirectView changeCategory(@RequestParam(value = "satelliteId") String satelliteId, Model model,
            RedirectAttributes redirectAttrs) {

        logger.info("submitted the update satellite with satelliteId : {}", satelliteId);

        redirectAttrs.addFlashAttribute("satelliteId", satelliteId);

        return new RedirectView("/web/add-satellite");
    }
}
