/*

 * Creation: 5 oct. 2016 by Imad Eddine BOUIHI
 *
 */
package com.osfglobal.hybris.emarsys.recommendations.commands;

import de.hybris.platform.site.BaseSiteService;

import java.util.List;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.osfglobal.hybris.emarsys.data.CommandData;


public abstract class AbstractCommandProvider
{

	protected List<String> patterns;
	protected String heroParameter;
	protected String commandName;

	protected PathMatcher pathMatcher;
	protected BaseSiteService baseSiteService;


	public abstract String getParameterString(final String uri);

	public abstract String getLogic();
	public abstract void  setExtraParameters(CommandData command);

	public CommandData getCommand(final String uri)
	{

		final CommandData command = new CommandData();
		command.setName(getCommandName());
		command.setParamString(getParameterString(uri));
		if (getLogic() != null)
		{
			command.setLogic(getLogic());
			command.setTemplate(getTemplateId());
			command.setContainerId(getContainerId());
		}
		setExtraParameters(command);

		return command;
	}

	public String getTemplateId()
	{
		return baseSiteService.getCurrentBaseSite().getEmarsysPredict().getTemplateId();
	}

	public String getContainerId()
	{
		return baseSiteService.getCurrentBaseSite().getEmarsysPredict().getContainerId();
	}

	public String getMatchinPattern(final String uri)
	{
		for (final String pattern : getPatterns())
		{
			if (getPathMatcher().match(pattern, uri))
			{
				return pattern;
			}
		}
		return null;
	}

	public PathMatcher getPathMatcher()
	{
		return new AntPathMatcher();
	}

	public void setPathMatcher(final PathMatcher pathMatcher)
	{
		this.pathMatcher = pathMatcher;
	}



	/**
	 * @return the patterns
	 */
	public List<String> getPatterns()
	{
		return patterns;
	}

	/**
	 * @param patterns
	 *           the patterns to set
	 */
	public void setPatterns(final List<String> patterns)
	{
		this.patterns = patterns;
	}

	public String getHeroParameter()
	{
		return heroParameter;
	}

	public void setHeroParameter(final String heroParameter)
	{
		this.heroParameter = heroParameter;
	}

	public String getCommandName()
	{
		return commandName;
	}

	public void setCommandName(final String commandName)
	{
		this.commandName = commandName;
	}

	/**
	 * @return the baseSiteService
	 */
	public BaseSiteService getBaseSiteService()
	{
		return baseSiteService;
	}

	/**
	 * @param baseSiteService
	 *           the baseSiteService to set
	 */
	public void setBaseSiteService(final BaseSiteService baseSiteService)
	{
		this.baseSiteService = baseSiteService;
	}



}
