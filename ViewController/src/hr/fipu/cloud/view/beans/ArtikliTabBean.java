package hr.fipu.cloud.view.beans;

import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.context.AdfFacesContext;

import org.apache.myfaces.trinidad.event.DisclosureEvent;

public class ArtikliTabBean {
    private RichPanelTabbed panelTabBind;
    private RichShowDetailItem firstTabBind;
    private RichShowDetailItem secTabBind;
    private RichShowDetailItem thirdTabBind;
    
    public ArtikliTabBean() {
    }

    /**
     * @Method to disclose First tab on button click
     */
    public void setDisclosedFirstTab(RichShowDetailItem tabBind) {
        RichPanelTabbed richPanelTabbed = getPanelTabBind();
        for (UIComponent child : richPanelTabbed.getChildren()) {
            RichShowDetailItem sdi = (RichShowDetailItem) child;
            if (sdi.getClientId().equals(tabBind.getClientId())) {
                sdi.setDisclosed(true);
            } else {
                sdi.setDisclosed(false);
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(panelTabBind);
    }

    /**
     * @param actionEvent
     */
    public void naviGateButtonAction(ActionEvent actionEvent) {
        if (firstTabBind.isDisclosed()) {
            setDisclosedFirstTab(secTabBind);
        } else if (secTabBind.isDisclosed()) {
            setDisclosedFirstTab(thirdTabBind);
        } else {
            setDisclosedFirstTab(firstTabBind);
        }
    }

    public void setPanelTabBind(RichPanelTabbed panelTabBind) {
        this.panelTabBind = panelTabBind;
    }

    public RichPanelTabbed getPanelTabBind() {
        return panelTabBind;
    }

    public void setFirstTabBind(RichShowDetailItem firstTabBind) {
        this.firstTabBind = firstTabBind;
    }

    public RichShowDetailItem getFirstTabBind() {
        return firstTabBind;
    }

    public void setSecTabBind(RichShowDetailItem secTabBind) {
        this.secTabBind = secTabBind;
    }

    public RichShowDetailItem getSecTabBind() {
        return secTabBind;
    }

    public void setThirdTabBind(RichShowDetailItem thirdTabBind) {
        this.thirdTabBind = thirdTabBind;
    }

    public RichShowDetailItem getThirdTabBind() {
        return thirdTabBind;
    }
}
