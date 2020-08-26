import jenkins.model.*
import hudson.model.*
import hudson.security.*
import hudson.plugins.*
import hudson.plugins.active_directory.*
import hudson.*
import jenkins.*
import jenkins.install.*

def instance = Jenkins.get()

if (instance.getSetupWizard() != null) {
    instance.setInstallState(InstallState.INITIAL_SETUP_COMPLETED)
}

println "--> configure LDAP"
String domain = "aldebaran.lan"
String site = "site"
String server = "ad-paris-0:3268, ad-paris-1:3268"
String bindName = "jenkins@aldebaran.lan"
String bindPassword = "{{ vault_ldap_password }}"

adrealm = new ActiveDirectorySecurityRealm(domain, site, bindName, bindPassword, server)
adrealm.getDomains().each({
    it.bindName = adrealm.bindName
    it.bindPassword = adrealm.bindPassword
})
instance.setSecurityRealm(adrealm)
instance.save()

println "--> configure Active Directory... done"
