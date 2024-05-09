package com.shubham.app.controller;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.shubham.app.model.LaunchType;
import com.shubham.app.render.RenderLauncherTemplate;
import com.shubham.app.service.LaunchersService;

import java.math.BigInteger;
import java.util.Map;
import java.util.Objects;
import jakarta.annotation.Resource;

@Controller
public class LauncherController {
    public static final String ZERO_LENGTH_STRING = "";
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private RenderLauncherTemplate renderLauncherTemplate;
    @Autowired
    private LaunchersService launchersService;

    @Resource
    @Lazy
    private Map<String, Object> resultMap;

    /**
     * Endpoint to render all launchers
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
    @GetMapping(value = {"/web/launchers"})
    public String getLaunchers(Model model, @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam(value = "pageNumber", required = false) BigInteger pageNumber,
            @RequestParam(value = "pageSize", required = false) BigInteger pageSize) {

        logger.info("Admin all launchers called with pageNumber : {}, pageSize : {} and searchText : {}", pageNumber,
                pageSize, searchText);
        model.addAttribute("errorMessage", model.asMap().get("errorMessage"));

        model.addAllAttributes(resultMap);
        renderLauncherTemplate.renderAllLaunchers(model, pageNumber, pageSize, searchText);

        return "launches";
    }

    /**
     * Endpoint to render the page that contains the form to create the new launcher
     */
    @GetMapping(value = {"/web/add-launcher"})
    public String getLaunchers(@ModelAttribute("launcherId") String launcherId, Model model) {

        logger.info("adding new launchers form page called");
        model.addAttribute("errorMessage", model.asMap().get("errorMessage"));
        if (!Objects.equals(launcherId, ZERO_LENGTH_STRING)) {
            logger.info("edit launcher page specific for launcherId : {}", launcherId);
            renderLauncherTemplate.renderDesiredLauncherEditPage(launcherId, model);
        }

        return "new-launcher";
    }

    /**
     * Endpoint used, when user fills and submits the form for creating a new
     * launcher
     */
    @PostMapping(value = {"/web/launchers/create-launcher"})
    @ResponseBody
    public Object createOrUpdateLauncher(@RequestParam(value = "dbId", required = false) Long dbId,
            @RequestParam(value = "launcherId") String launcherId,
            @RequestParam(value = "launcherType") LaunchType launcherType,
            @RequestParam(value = "registeredOn") String registeredOn, Model model, RedirectAttributes redirectAttrs) {

        logger.info(
                "Create new launcher called with launcherId : {}, launcherType : {}, registeredOn : {} and dbId : {}",
                launcherId, launcherType, registeredOn, dbId);
        try {
            // creating a new-launcher
            launchersService.createOrUpdateLauncher(launcherId, launcherType, registeredOn, dbId, redirectAttrs);

        } catch (Exception e) {
            logger.error("error while creating a launcher : {}", e.getMessage());
            redirectAttrs.addFlashAttribute("errorMessage", "Unable to create launcher : " + e.getMessage());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        logger.info("Redirecting to all launchers page");
        return new RedirectView("/web/launchers");
    }

    @PostMapping(value = {"/web/launchers/delete-launcher"})
    @ResponseBody
    public Object deleteLauncher(@RequestParam(value = "launcherIdSelected") String launcherId, Model model,
            RedirectAttributes redirectAttrs) {

        logger.info("Deleting the existing launcher called with id: {}", launcherId);
        try {
            launchersService.deleteLauncher(launcherId);
            redirectAttrs.addFlashAttribute("successMessage",
                    "Successfully deleted existing launcher with launcherId : " + launcherId);
        } catch (Exception e) {
            logger.error("error while updating the status : {}", e.getMessage());
            redirectAttrs.addFlashAttribute("errorMessage", "Unable to delete launcher with cause : " + e.getMessage());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        logger.info("Redirecting to all launchers page");
        return new RedirectView("/web/launchers");
    }

    @PostMapping(value = {"/web/update-launcher"})
    @ResponseBody
    public RedirectView changeCategory(@RequestParam(value = "launcherId") String launcherId, Model model,
            RedirectAttributes redirectAttrs) {

        logger.info("submitted the update launcher with launcherId : {}", launcherId);

        redirectAttrs.addFlashAttribute("launcherId", launcherId);

        return new RedirectView("/web/add-launcher");
    }
}
